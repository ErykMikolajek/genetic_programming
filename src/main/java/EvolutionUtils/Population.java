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
            System.out.println("---------- Gen: " + generation + " ----------");
            System.out.println(newIndividual.plot());
            System.out.println("------------------------------------");
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
            System.out.println("---------- Gen: " + generation + " ----------");
            System.out.println(crossoverIndividual.plot());
            System.out.println("------------------------------------");
            newIndividuals.add(crossoverIndividual);
            Individual randomIndividual = new Individual();
            randomIndividual.generate(this.PROGRAMS_DEPTH);
            System.out.println("---------- Gen: " + generation + " ----------");
            System.out.println(randomIndividual.plot());
            System.out.println("------------------------------------");
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
            if (programFitness == 0){
                isProblemSolved = true;
                solvedIndividual = individual;
            }
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
