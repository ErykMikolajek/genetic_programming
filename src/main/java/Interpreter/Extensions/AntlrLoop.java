package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrLoop extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitForLoop(MiniGPLangParser.ForLoopContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        AntlrBlock blockVisitor = new AntlrBlock();

        for (int i = 0; i < ((Variable) expressionVisitor.visit(ctx.expression())).value; i++)
            blockVisitor.visit(ctx.block());

        return null;
    }

    @Override
    public Command visitWhileLoop(MiniGPLangParser.WhileLoopContext ctx) {
        AntlrBoolStatement boolStatement = new AntlrBoolStatement();
        AntlrBlock commandBlock = new AntlrBlock();
        BoolStatement statement = boolStatement.visit(ctx.boolStatement());

        while (statement.satisfied){
            commandBlock.visitBlock(ctx.block());
            statement.satisfied = boolStatement.visit(ctx.boolStatement()).satisfied;
        }

        return null;
    }
}
