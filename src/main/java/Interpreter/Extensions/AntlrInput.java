package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.util.Scanner;

public class AntlrInput extends MiniGPLangBaseVisitor<Variable> {
    @Override
    public Variable visitInput(MiniGPLangParser.InputContext ctx) {
        Scanner inputFile = AntlrProgram.inputFile;
        if (inputFile.hasNextLine()) {
            String data = inputFile.nextLine();
            int value = Integer.parseInt(data);
            return new Variable(value);
        }
        else throw new BadProgramException("RuntimeException: Insufficient data in input file\n" +
                "The program attempted to read more numbers from the input file than are available.\n");
    }

}
