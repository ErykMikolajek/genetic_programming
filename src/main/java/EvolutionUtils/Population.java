package EvolutionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Population {
    public ArrayList<Individual> population;
    public int PROGRAMS_DEPTH = 3;
    public int PROGRAMS_MAX_OPERATIONS = 20;
    public String outputFile = "output1.txt";
    static Random random = new Random();
    public ArrayList<Integer> outputTemplateVector;


    public Population(String outputFile){
        this.outputFile = outputFile;
        outputTemplateVector = new ArrayList<>();

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
        for (int i = 0; i < populationSize; i++){
            Individual newIndividual = new Individual();
            newIndividual.generate(this.PROGRAMS_DEPTH);
            population.add(newIndividual);
        }
    }

    public void generateNewPopulation(ArrayList<Individual> bestIndividuals){
        ArrayList<Individual> newIndividuals = new ArrayList<>();
        for (int i = 0; i < population.size()/2; i++){
            int program1 = random.nextInt(bestIndividuals.size());
            int program2 = random.nextInt(bestIndividuals.size());
            while (program1 == program2) program2 = random.nextInt(bestIndividuals.size());

            System.out.println(bestIndividuals.get(program1).plot());
            System.out.println("----------------");
            System.out.println(bestIndividuals.get(program2).plot());
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
            double programFitness = 0;
            ArrayList<Integer> programOutput = individual.eval(PROGRAMS_MAX_OPERATIONS);
            programFitness += abs(this.outputTemplateVector.size() - programOutput.size()) * 100;
            if (individual.isFailed) programFitness += 500;

            individual.fitness = programFitness;
            avgFitness += programFitness;
//            System.out.println(programFitness);
//            if (individual.fitness >= 2000.0) System.out.println(individual.plot());
        }
        System.out.println("Average fitness: " + avgFitness/this.population.size());
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
