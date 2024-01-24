package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.util.Scanner;

public class AntlrInput extends MiniGPLangBaseVisitor<Variable> {
    @Override
    public Variable visitInput(MiniGPLangParser.InputContext ctx) {
        if (!AntlrProgram.inputVector.isEmpty()) {
            int value = AntlrProgram.inputVector.remove(0);
            return new Variable(value);
        }
        else return new Variable(0);
//        else throw new BadProgramException("RuntimeException: Insufficient data in input vector\n" +
//                "The program attempted to read more numbers from the input vector than are available.\n");
    }

}
