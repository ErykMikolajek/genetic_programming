package EvolutionUtils;

import java.io.IOException;

public class GProject {
    public static void main(String[] args) {
        for (int i =0; i < 1000; i++){
        Individual test1 = new Individual();
        Individual test2 = new Individual();
        test1.generate(3);
        test2.generate(3);
        test1.mutate();
        System.out.println(test1.plot());
        test1.eval(20);
//        Individual test3 = test1.crossover(test2);
//        System.out.println(test3.plot());
//        System.out.println(test3.eval(50));
        }
//        run(100);
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
