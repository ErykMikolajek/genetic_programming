package antlr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Individual program1 = new Individual(8);
        System.out.println();
        System.out.println(program1.plot());
//        Individual program2 = new Individual();

//        System.out.println();
//        program1.generateProgram(5);
//        program2.generateIndividual(5);

//        program1.print(program1.head);
//        program1.save("program1.json");
//        program1.head = program1.load("program1.json");
//        System.out.println("\n");
//        program1.selfRepresent(program1.head);
//        System.out.println();
//        program2.selfRepresent(program2.head);
//
//        Individual program3 = program1.crossover(program2);
//        System.out.println();
//        program3.selfRepresent(program3.head);
//        program1.MUTATION_PER_NODE = 0.5;
//        System.out.println();
//        System.out.println();
//        program1.mutate(program1.head);
//        program1.selfRepresent(program1.head);
    }
}
