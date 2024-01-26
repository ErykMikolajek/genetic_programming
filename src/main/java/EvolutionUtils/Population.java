package EvolutionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.abs;

public class Population {
    public ArrayList<Individual> population;
    public int PROGRAMS_DEPTH = 3;
    public int PROGRAMS_MAX_OPERATIONS = 1000;
//    private static final double SIMILARITY_WEIGHT = 0.7;
//    private static final double GRAMMATICAL_WEIGHT = 0.3;
    private static final double FIT_THRESHOLD = 0;
    private int populationSize;
    public String inputFile;
    public boolean isProblemSolved;
    public Individual solvedIndividual;
    private int generation;
    static Random random = new Random();
    public int testCases;
    public ArrayList<int[]> inputVector;
    public ArrayList<int[]> targetOutputVector;

    public Population(String inputFile){
        this.inputFile = inputFile;
        inputVector = new ArrayList<>();
        targetOutputVector = new ArrayList<>();
        this.isProblemSolved = false;

        try {
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);
            testCases = scanner.nextInt();
            int inputNumbers = scanner.nextInt();
            int outputNumbers = scanner.nextInt();

            for (int i = 0; i < testCases; i++){
                int[] inputValues = new int[inputNumbers];
                for (int j = 0; j < inputNumbers; j++) inputValues[j] = scanner.nextInt();
                inputVector.add(inputValues);

                int[] outputValues = new int[outputNumbers];
                for (int j = 0; j < outputNumbers; j++) outputValues[j] = scanner.nextInt();
                targetOutputVector.add(outputValues);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Population(int[][] inputMatrix){
        inputVector = new ArrayList<>();
        targetOutputVector = new ArrayList<>();
        this.isProblemSolved = false;

        testCases = inputMatrix[0][0];
        int inputNumbers = inputMatrix[0][1];
        int outputNumbers = inputMatrix[0][2];

        for (int i = 0; i < testCases; i++){
            int[] inputValues = new int[inputNumbers];
            System.arraycopy(inputMatrix[i + 1], 0, inputValues, 0, inputNumbers);
            inputVector.add(inputValues);

            int[] outputValues = new int[outputNumbers];
            System.arraycopy(inputMatrix[i + 1], inputNumbers, outputValues, 0, outputNumbers);
            targetOutputVector.add(outputValues);

        }


    }

    public void createPopulation(int populationSize){
        this.populationSize = populationSize;
        this.population = new ArrayList<>(populationSize);
        generation = 1;
        for (int i = 0; i < populationSize; i++){
            Individual newIndividual = new Individual();
            newIndividual.generate(this.PROGRAMS_DEPTH);
            population.add(newIndividual);
        }
    }

    public void generateNewPopulation(ArrayList<Individual> bestIndividuals){
        generation++;
        // New pop:
        // 5 - previous best individuals, 25% - crossovers, 25% - best individuals mutations,
        // 25% - children mutations, 25% - 5 - new individuals
        ArrayList<Individual> newIndividuals = new ArrayList<>(populationSize);
        for (Individual bestIndividual : bestIndividuals){
            Individual newBest = new Individual(bestIndividual);
            newBest.fitness = bestIndividual.fitness;
            newIndividuals.add(newBest);
        }

        // best individuals mutations:
        for (int j = 0; j < populationSize/4; j++) {
            Individual bestIndividualMutation = new Individual(bestIndividuals.get(j % bestIndividuals.size()));
            bestIndividualMutation.mutate();
            bestIndividualMutation.fitness = 0;
            newIndividuals.add(bestIndividualMutation);
        }

        for (int i = 0; i < populationSize/4; i++) {
            // crossovers:
            int program1 = random.nextInt(bestIndividuals.size());
            int program2 = random.nextInt(bestIndividuals.size());
            while (program1 == program2) program2 = random.nextInt(bestIndividuals.size());
            Individual parent1 = new Individual(bestIndividuals.get(program1));
            Individual parent2 = new Individual(bestIndividuals.get(program2));
//            Individual crossoverIndividual = new Individual(
//                    bestIndividuals.get(program1).crossover(bestIndividuals.get(program2)));
            Individual crossoverIndividual = new Individual(parent1.crossover(parent2));
            crossoverIndividual.fitness = 0;
            newIndividuals.add(crossoverIndividual);

            // children mutations
            Individual crossoverMutation = new Individual(crossoverIndividual);
            crossoverMutation.mutate();
            crossoverMutation.fitness = 0;
            newIndividuals.add(crossoverMutation);
        }
        // new individuals
        int individualsLeft = populationSize - newIndividuals.size();
        for (int i = 0; i < individualsLeft; i++){
            Individual randomIndividual = new Individual();
            randomIndividual.generate(this.PROGRAMS_DEPTH);
            newIndividuals.add(randomIndividual);
        }
        this.population.clear();
        this.population.addAll(newIndividuals);

    }

    public void updatePopulationFitness(){
        for (Individual individual : this.population) {
            double similarityRatio = 0;
            for (int i = 0; i < testCases; i++) {
                int[] generatedVector = individual
                        .eval(PROGRAMS_MAX_OPERATIONS, inputVector.get(i)).stream().mapToInt(k -> k).toArray();
                int[] targetVector = targetOutputVector.get(i);

                similarityRatio += calculateSimilarity(targetVector, generatedVector);
                double outputExistent = generatedVector.length == 0 ? 999 : 0;
                similarityRatio += outputExistent;
                double grammaticalScore = individual.isFailed ? 999 : 0;
                similarityRatio += grammaticalScore;
            }
            individual.fitness = similarityRatio;

            if (individual.fitness <= FIT_THRESHOLD) {
                isProblemSolved = true;
                solvedIndividual = individual;
                break;
            }
        }
        plotData();
    }

    private static double calculateSimilarity(int[] targetVector, int[] generatedVector) {
        double similarity = 0;
        // ((-1/(x+1)) + 1)*5
        int lengthDifference = Math.abs(targetVector.length - generatedVector.length);
//        similarity += (lengthDifference * lengthDifference);
        similarity += (((double) -1 /(lengthDifference+1)) + 1)*5;

        for (int i = 0; i < Math.min(targetVector.length, generatedVector.length); i++){
            similarity += Math.abs(targetVector[i] - generatedVector[i]);
        }

        return similarity;
    }


    public ArrayList<Individual> selectKBest(int k){
        ArrayList<Individual> elite = new ArrayList<>(k);
        ArrayList<Individual> populationCopy = new ArrayList<>(this.population);
        for (int i = 0; i < k; i++) {
            int maxIndex = 0, popTempSize = populationCopy.size();
            for (int j = 1; j < popTempSize; j++) {
                if (populationCopy.get(j).fitness < populationCopy.get(maxIndex).fitness) {
                    maxIndex = j;
                }
            }
            elite.add(populationCopy.remove(maxIndex));
        }
        return elite;
    }

    public void plotData(){
        double avgFitness = 0;
        for (Individual ind : population) {
            avgFitness += ind.fitness;
        }
        avgFitness /= populationSize;
        Individual bestOfPopulation = selectKBest(1).get(0);
        double bestFitness = bestOfPopulation.fitness;
        System.out.println("Generation: " + generation +
                ", average fitness: " + avgFitness + ", best fitness: " + bestFitness);
        System.out.println("Best individual: " + bestOfPopulation.plot());
    }

}
