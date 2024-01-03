package EvolutionUtils;

import java.io.IOException;
import java.util.Arrays;

public class GProject {
    public static void main(String[] args) {
        run(100000);
    }

    public static void run(int iterations){
        Population population = new Population("target/inputFile.txt");
        population.createPopulation(100000);

        for (int i = 0; i < iterations; i++) {
            population.updatePopulationFitness();
            population.generateNewPopulation(population.selectKBest(5));
            if (population.isProblemSolved){
                System.out.println("----------- PROBLEM SOLVED: -----------");
                System.out.println(population.solvedIndividual.plot());
                System.out.println(population.solvedIndividual.fitness);
//                System.out.println(Arrays.toString(population.solvedIndividual.eval(10).stream().mapToInt(l -> l).toArray()));
                System.out.println("---------------------------------------");
                break;
            }
        }
        if (!population.isProblemSolved)
            System.out.println("--------- PROBLEM NOT SOLVED ---------");
    }
}
