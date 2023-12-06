package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrCommand extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitCommandLoop(MiniGPLangParser.CommandLoopContext ctx) {
        AntlrLoop loopVisitor = new AntlrLoop();
        return loopVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandIfStatement(MiniGPLangParser.CommandIfStatementContext ctx) {
        AntlrIfStatement ifStatementVisitor = new AntlrIfStatement();
        return ifStatementVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandExpression(MiniGPLangParser.CommandExpressionContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        return expressionVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandAssign(MiniGPLangParser.CommandAssignContext ctx) {
        AntlrAssignVariable assignVariableVisitor = new AntlrAssignVariable();
        return assignVariableVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitCommandOutput(MiniGPLangParser.CommandOutputContext ctx) {
        AntlrOutput outputVisitor = new AntlrOutput();
        return outputVisitor.visit(ctx.getChild(0));
    }
}
