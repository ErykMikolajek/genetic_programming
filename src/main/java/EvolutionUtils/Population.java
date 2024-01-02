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
    private static final double FIT_THRESHOLD = 10;
    public String outputFile = "output1.txt";
    public boolean isProblemSolved;
    public Individual solvedIndividual;
    private int generation;
    static Random random = new Random();
    public ArrayList<Integer> outputTemplateVector;


    public Population(String outputFile){
        this.outputFile = outputFile;
        outputTemplateVector = new ArrayList<>();
        this.isProblemSolved = false;

        try {
            File file = new File(outputFile);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                outputTemplateVector.add(Integer.parseInt(line));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
        for (Individual individual : this.population){
            int[] generatedVector = individual.eval(PROGRAMS_MAX_OPERATIONS).stream().mapToInt(i -> i).toArray();
            int[] targetVector = outputTemplateVector.stream().mapToInt(i -> i).toArray();

            double similarityRatio = calculateSimilarity(targetVector, generatedVector);
//            double grammaticalScore = individual.isFailed ? 0.0 : 1 + GRAMMATICAL_WEIGHT;
            double grammaticalScore = individual.isFailed ? 100.0 : 0.0;
            similarityRatio += grammaticalScore;
            individual.fitness = similarityRatio;

            avgFitness += individual.fitness;
            if (individual.fitness <= FIT_THRESHOLD){
//                System.out.println("Individual fitness: " + individual.fitness);
//                System.out.println("Generated vector: " + Arrays.toString(generatedVector));
//                System.out.println("Target vector: " + Arrays.toString(targetVector));
                isProblemSolved = true;
                solvedIndividual = individual;
            }
//            if (Math.abs(targetVector.length - generatedVector.length) == 0 && !individual.isFailed){
////                System.out.println("Individual fitness: " + individual.fitness);
////                System.out.println("Generated vector: " + Arrays.toString(generatedVector));
////                System.out.println("Target vector: " + Arrays.toString(targetVector));
//                isProblemSolved = true;
//                solvedIndividual = individual;
//            }

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

//        return 1.0 - ((double) dp[targetVector.length][generatedVector.length] / Math.max(targetVector.length, generatedVector.length));
//        System.out.println("--------");
//        System.out.println("Generated vector: " + Arrays.toString(generatedVector));
//        System.out.println("Target vector: " + Arrays.toString(targetVector));
//        System.out.println("Length difference: " + lengthDifference);
//        System.out.println("Similarity: " + similarity);
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
