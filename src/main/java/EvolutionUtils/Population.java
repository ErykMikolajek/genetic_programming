package EvolutionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Population {
    public ArrayList<Individual> population;
    public int PROGRAMS_DEPTH = 6;
    public int PROGRAMS_MAX_OPERATIONS = 10;
    private static final double SIMILARITY_WEIGHT = 0.7;
    private static final double GRAMMATICAL_WEIGHT = 0.3;
    private static final double FIT_THRESHOLD = 0.001;
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
        this.population = new ArrayList<>(populationSize);
        generation = 1;
        for (int i = 0; i < populationSize; i++){
            Individual newIndividual = new Individual();
            newIndividual.generate(this.PROGRAMS_DEPTH);
            population.add(newIndividual);
        }
    }

    public void generateNewPopulation(ArrayList<Individual> bestIndividuals){
        ArrayList<Individual> newIndividuals = new ArrayList<>();
        generation++;
        for (int i = 0; i < population.size()/2; i++){
            int program1 = random.nextInt(bestIndividuals.size());
            int program2 = random.nextInt(bestIndividuals.size());
            while (program1 == program2) program2 = random.nextInt(bestIndividuals.size());

            Individual crossoverIndividual = bestIndividuals.get(program1).crossover(bestIndividuals.get(program2));
            crossoverIndividual.mutate();
            newIndividuals.add(crossoverIndividual);
            Individual randomIndividual = new Individual();
            randomIndividual.generate(this.PROGRAMS_DEPTH);
            newIndividuals.add(randomIndividual);
        }
        this.population = newIndividuals;
    }

    public void updatePopulationFitness(){
        double avgFitness = 0;
        for (Individual individual : this.population) {
            double similarityRatio = 0;
            for (int i = 0; i < testCases; i++) {
                int[] generatedVector = individual.eval(PROGRAMS_MAX_OPERATIONS, inputVector.get(i)).stream().mapToInt(k -> k).toArray();
                int[] targetVector = targetOutputVector.get(i);

                similarityRatio += calculateSimilarity(targetVector, generatedVector);
    //            double grammaticalScore = individual.isFailed ? 0.0 : 1 + GRAMMATICAL_WEIGHT;
                double grammaticalScore = individual.isFailed ? 100.0 : 0.0;
                similarityRatio += grammaticalScore;
//                if (similarityRatio == 0) {
//                    System.out.println("Generated vector: " + Arrays.toString(generatedVector));
//                    System.out.println("Target vector: " + Arrays.toString(targetVector));
//                    System.out.println("Fitness: " + similarityRatio);
//                }
            }
            individual.fitness = similarityRatio;

            avgFitness += individual.fitness;
            if (individual.fitness <= FIT_THRESHOLD){
//                System.out.println("Individual fitness: " + individual.fitness);
//                System.out.println("Generated vector: " + Arrays.toString(generatedVector));
//                System.out.println("Target vector: " + Arrays.toString(targetVector));
                isProblemSolved = true;
                solvedIndividual = individual;
            }
        }
        System.out.println("Generation: " + generation + ", average fitness: " + avgFitness/this.population.size());
    }

//    public static double calculateFitness(int[] targetVector, int[] generatedVector, boolean grammaticalCorrectness) {
//        double similarityRatio = calculateSimilarity(targetVector, generatedVector);
//        double grammaticalScore = grammaticalCorrectness ? GRAMMATICAL_WEIGHT : 0.0;
//        double differenceLength = Math.abs(targetVector.length - generatedVector.length) /
//                (double) Math.max(targetVector.length, generatedVector.length);
//
//        return (SIMILARITY_WEIGHT * similarityRatio) + ((1 - SIMILARITY_WEIGHT) * (1 - differenceLength)) + grammaticalScore;
//    }

    private static double calculateSimilarity(int[] targetVector, int[] generatedVector) {
        double similarity = 0;
        int lengthDifference = Math.abs(targetVector.length - generatedVector.length);
        similarity += SIMILARITY_WEIGHT * (lengthDifference);

        double difference = Math.abs(Arrays.stream(generatedVector).sum() - Arrays.stream(targetVector).sum());
        similarity += difference;

        for (int i = 0; i < Math.min(targetVector.length, generatedVector.length); i++){
            if (targetVector[i] != generatedVector[i])
                similarity += (double) Math.abs(targetVector[i] - generatedVector[i]) / Math.abs(targetVector[i]);
        }

        return similarity;
    }


    public ArrayList<Individual> selectKBest(int k){
        ArrayList<Individual> tempArray = new ArrayList<>(this.population);
        ArrayList<Individual> elite = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            int maxIndex = 0;

            for (int j = 1; j < tempArray.size(); j++) {
                if (tempArray.get(j).fitness > tempArray.get(maxIndex).fitness) {
                    maxIndex = j;
                }
            }

            elite.add(tempArray.remove(maxIndex));
        }
        return elite;
    }


}
