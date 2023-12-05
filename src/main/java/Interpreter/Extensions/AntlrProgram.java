package Interpreter.Extensions;

import EvolutionUtils.Program;
import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrProgram extends MiniGPLangBaseVisitor<Program> {

    public static void evaluateCommand(Command command) {
        if (command instanceof IfStatement statement) {
            if (statement.ifBlockSatisfied) {
                for (Command blockCommand : statement.ifBlock.commands)
                    evaluateCommand(blockCommand);
            }
            else if (statement.elseBlock != null) {
                for (Command blockCommand : statement.elseBlock.commands)
                    evaluateCommand(blockCommand);
            }
        }
    }
    @Override
    public Program visitProgram(MiniGPLangParser.ProgramContext ctx) {
        AntlrCommand lineVisitor = new AntlrCommand();
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            Command command = lineVisitor.visit(ctx.getChild(i));
            evaluateCommand(command);
            if (command instanceof Variable){
                System.out.println(((Variable) command).value);
            }
        }
        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
        return super.visitProgram(ctx);
    }
}
