package antlr;

public class Main {
    public static void main(String[] args) {
        
        Individual program1 = new Individual();
        Individual program2 = new Individual();

        program1.generateIndividual(5);
        program2.generateIndividual(5);

        program1.selfRepresent(program1.head);
//        System.out.println();
//        program2.selfRepresent(program2.head);
//
//        Individual program3 = program1.crossover(program2);
//        System.out.println();
//        program3.selfRepresent(program3.head);
        program1.MUTATION_PER_NODE = 0.5;
        System.out.println();
        System.out.println();
        program1.mutate(program1.head);
        program1.selfRepresent(program1.head);
    }
}
