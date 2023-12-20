package EvolutionUtils;

import java.io.IOException;

public class GProject {
    public static void main(String[] args) {
        run(100);
    }

    public static void run(int iterations){
        Population population = new Population("target/output1.txt");
        population.createPopulation(100);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            population.generateNewPopulation(population.selectKBest(5));
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println("---------------------------------------");
                break;
            }
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }
}
