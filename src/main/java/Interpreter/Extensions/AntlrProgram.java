package Interpreter.Extensions;

import EvolutionUtils.Program;
import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class AntlrProgram extends MiniGPLangBaseVisitor<Program> {

    public String programOutput = "";
    public static Scanner inputFile;
    //TODO: Naprawic petle, dodac instrukjce input

    public AntlrProgram(String inputFileName){
        File inFile = new File("target/" + inputFileName);
        try {
            inputFile = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//        else if (command instanceof Output output) {
//            programOutput += output.value + "\n";
//        }
//        else if (command instanceof AssignVariable assignVariable){
//            VariablesTable.addVariable(assignVariable.name, assignVariable.var.value);
//        }
    @Override
    public Program visitProgram(MiniGPLangParser.ProgramContext ctx)  {
        AntlrCommand commandVisitor = new AntlrCommand();
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            Command command = commandVisitor.visit(ctx.getChild(i));
        }

        inputFile.close();
//        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
        System.out.println("\nZmienne:");
        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
        return super.visitProgram(ctx);
    }
}
