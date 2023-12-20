package EvolutionUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
//        Individual program1 = new Individual();
//        program1.generate(2);
//        System.out.println("------------- Program: -------------");
//        System.out.println(program1.plot());
//        System.out.println("------------------------------------");
//        System.out.println("--------------- Eval: --------------");
//        System.out.println(program1.eval(20));
//        System.out.println("------------------------------------");
        Individual p1 = new Individual();
        p1.generate(2);
        System.out.println(p1.plot());
        System.out.println("------------------------------------");
        Individual p2 = new Individual();
        p2.generate(2);
        System.out.println(p2.plot());
        System.out.println("------------------------------------");
        Individual p3 = p1.crossover(p2);
        System.out.println(p3.plot());

    }
}
