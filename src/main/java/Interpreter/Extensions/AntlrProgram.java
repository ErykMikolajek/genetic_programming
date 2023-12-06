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
            } else if (statement.elseBlock != null) {
                for (Command blockCommand : statement.elseBlock.commands)
                    evaluateCommand(blockCommand);
            }
        }
//        else if (command instanceof Loop) {
//            if (((Loop) command).isForLoop) {
//                for (int iteration = 0; iteration < ((Loop) command).range; iteration++) {
//                    for (Command blockCommand : ((Loop) command).commandsBlock.commands) {
//                        evaluateCommand(blockCommand);
////                        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
//                    }
//                }
//            } else {
//                for (Command blockCommand : ((Loop) command).commandsBlock.commands) {
//                    evaluateCommand(blockCommand);
//                }
//            }
//        }
        else if (command instanceof Variable) {
            System.out.println(((Variable) command).value);
        }
//        else if (command instanceof AssignVariable assignVariable){
//            VariablesTable.addVariable(assignVariable.name, assignVariable.var.value);
//        }
    }

    @Override
    public Program visitProgram(MiniGPLangParser.ProgramContext ctx) {
        AntlrCommand commandVisitor = new AntlrCommand();
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            Command command = commandVisitor.visit(ctx.getChild(i));
            if (command instanceof Loop && !(((Loop) command).isForLoop))
            {
                boolean state = ((Loop) command).satisfied;
                while (state) {
                    evaluateCommand(command);
                    command = commandVisitor.visit(ctx.getChild(i));
                    state = ((Loop) command).satisfied;
                }
            } else if (command instanceof Loop && ((Loop) command).isForLoop) {
                for (int iteration = 0; iteration < ((Loop) command).range; iteration++) {
                    for (Command blockCommand : ((Loop) command).commandsBlock.commands) {
                        evaluateCommand(blockCommand);
//                        command = commandVisitor.visit(ctx.getChild(i));
//                        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
                    }
                    command = commandVisitor.visit(ctx.getChild(i));

                }
            }
            else evaluateCommand(command);
        }
        for (String ss : VariablesTable.savedVariables.keySet()) System.out.println(ss + ": " + VariablesTable.getVariableValue(ss));
        return super.visitProgram(ctx);
    }
}
