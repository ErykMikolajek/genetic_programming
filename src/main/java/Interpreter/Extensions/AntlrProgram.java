package Interpreter.Extensions;

import EvolutionUtils.Program;
import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.stream.Collectors;

public class AntlrProgram extends MiniGPLangBaseVisitor<Program> {

    public static ArrayList<Integer> programOutput = new ArrayList<>();
    public static boolean didProgramFail = false;
//    public static Scanner inputFile;
    public static ArrayList<Integer> inputVector;
    static int maxOperationCount;

    public AntlrProgram(int[] inputVector, int maxCount){
        maxOperationCount = maxCount;
        programOutput = new ArrayList<>();
        VariablesTable.reset();
        didProgramFail = false;

        AntlrProgram.inputVector = Arrays.stream(inputVector).boxed().collect(Collectors.toCollection(ArrayList::new));
//        File inFile = new File("target/" + inputFileName);
//        try {
//            inputFile = new Scanner(inFile);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public Program visitProgram(MiniGPLangParser.ProgramContext ctx)  {
        AntlrCommand commandVisitor = new AntlrCommand();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            try {
                commandVisitor.visit(ctx.getChild(i));
            } catch (RuntimeException exception) {
//                System.out.println("Program couldn't evaluate");
                didProgramFail = true;
                break;
            }
        }

//        inputFile.close();
        return null;
    }
}
