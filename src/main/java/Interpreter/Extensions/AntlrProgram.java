package Interpreter.Extensions;

import EvolutionUtils.Program;
import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrProgram extends MiniGPLangBaseVisitor<Program> {

    //TODO: Naprawic petle, dodac instrukjce input


    @Override
    public Program visitProgram(MiniGPLangParser.ProgramContext ctx) {
        AntlrCommand commandVisitor = new AntlrCommand();
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            Command command = commandVisitor.visit(ctx.getChild(i));
        }
        System.out.println("\nZmienne:");
        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
        return super.visitProgram(ctx);
    }
}
