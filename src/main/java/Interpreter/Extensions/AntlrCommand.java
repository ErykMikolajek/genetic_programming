package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrCommand extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitCommandLoop(MiniGPLangParser.CommandLoopContext ctx) {
        AntlrLoop loopVisitor = new AntlrLoop();
        if (AntlrProgram.maxOperationCount-- <= 0)
            throw new BadProgramException("RuntimeException: Maximum Operations Exceeded\n" +
                "The program has exceeded the allowable limit for operations.");
        return loopVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandIfStatement(MiniGPLangParser.CommandIfStatementContext ctx) {
        AntlrIfStatement ifStatementVisitor = new AntlrIfStatement();
        if (AntlrProgram.maxOperationCount-- <= 0)
            throw new BadProgramException("RuntimeException: Maximum Operations Exceeded\n" +
                    "The program has exceeded the allowable limit for operations.");
        return ifStatementVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandExpression(MiniGPLangParser.CommandExpressionContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        if (AntlrProgram.maxOperationCount-- <= 0)
            throw new BadProgramException("RuntimeException: Maximum Operations Exceeded\n" +
                    "The program has exceeded the allowable limit for operations.");
        return expressionVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandAssign(MiniGPLangParser.CommandAssignContext ctx) {
        AntlrAssignVariable assignVariableVisitor = new AntlrAssignVariable();
        if (AntlrProgram.maxOperationCount-- <= 0)
            throw new BadProgramException("RuntimeException: Maximum Operations Exceeded\n" +
                    "The program has exceeded the allowable limit for operations.");
        return assignVariableVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandOutput(MiniGPLangParser.CommandOutputContext ctx) {
        AntlrOutput outputVisitor = new AntlrOutput();
        if (AntlrProgram.maxOperationCount-- <= 0)
            throw new BadProgramException("RuntimeException: Maximum Operations Exceeded\n" +
                "The program has exceeded the allowable limit for operations.");
        return outputVisitor.visit(ctx.getChild(0));
    }
}
