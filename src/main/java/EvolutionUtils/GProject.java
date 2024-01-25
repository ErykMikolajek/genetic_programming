package EvolutionUtils;

import java.io.IOException;
import java.util.Arrays;

public class GProject {

    public static void main(String[] args) {
//        run(100000);
        System.out.println(280/10);
    }

    public static void run(int iterations){
        Population population = new Population("target/inputFile.txt");
        population.createPopulation(100000);
        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("Program fitness: " + population.solvedIndividual.fitness);
                System.out.println("---------------------------------------");
                break;
            }
            population.generateNewPopulation(population.selectKBest(5));
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }

    public static void run(int iterations, String inputFileName){
        Population population = new Population(inputFileName);
        population.createPopulation(10000);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("Program fitness: " + population.solvedIndividual.fitness);
                System.out.println("---------------------------------------");
                break;
            }
            population.generateNewPopulation(population.selectKBest(5));
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }

    public static void run(int iterations, int[][] inputMatrix, int maxRandomValue){
        Individual.MAX_RANDOM_VALUE = maxRandomValue;
        Population population = new Population(inputMatrix);
        population.createPopulation(10000);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("Program fitness: " + population.solvedIndividual.fitness);
                System.out.println("---------------------------------------");
                break;
            }
            population.generateNewPopulation(population.selectKBest(5));
        }

        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }
}
