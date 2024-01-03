package EvolutionUtils;

import java.io.IOException;
import java.util.Arrays;

public class GProject {
    public static void main(String[] args) {
        run(100000);
    }

    public static void run(int iterations){
        Population population = new Population("target/inputFile.txt");
        population.createPopulation(10000);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            population.generateNewPopulation(population.selectKBest(5));
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("Program fitness: " + population.solvedIndividual.fitness);
                System.out.println("---------------------------------------");
                break;
            }
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }

    public static void run(int iterations, String inputFileName){
        Population population = new Population(inputFileName);
        population.createPopulation(10000);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            population.generateNewPopulation(population.selectKBest(5));
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("Program fitness: " + population.solvedIndividual.fitness);
                System.out.println("---------------------------------------");
                break;
            }
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }

    public static void run(int iterations, int[][] inputMatrix){
        Population population = new Population(inputMatrix);
        population.createPopulation(10000);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            population.generateNewPopulation(population.selectKBest(5));
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("Program fitness: " + population.solvedIndividual.fitness);
                System.out.println("---------------------------------------");
                break;
            }
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }
}
