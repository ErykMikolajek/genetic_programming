package Interpreter.Extensions;

import EvolutionUtils.Program;
import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class AntlrProgram extends MiniGPLangBaseVisitor<Program> {

    public static String programOutput = "";
    public static Scanner inputFile;
    static int maxOperationCount;

    public AntlrProgram(String inputFileName, int maxCount){
        programOutput = "";
        maxOperationCount = maxCount;
        File inFile = new File("target/" + inputFileName);
        try {
            inputFile = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Program visitProgram(MiniGPLangParser.ProgramContext ctx)  {
        AntlrCommand commandVisitor = new AntlrCommand();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            try {
                commandVisitor.visit(ctx.getChild(i));
            } catch (RuntimeException exception) {
                System.out.println("Program went into some trouble");
                break;
            }
        }

        inputFile.close();
//        System.out.println("\nZmienne:");
//        for (String ss : VariablesTable.savedVariables.keySet())
//            System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));

        return null;
    }
}
