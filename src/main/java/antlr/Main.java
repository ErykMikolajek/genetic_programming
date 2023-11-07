package antlr;

public class Main {
    public static void main(String[] args) {
        
        Individual program = new Individual();
        program.generateIndividual(5);
        program.selfRepresent(program.head);
    }
}
