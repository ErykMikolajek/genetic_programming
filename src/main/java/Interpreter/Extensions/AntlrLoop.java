package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrLoop extends MiniGPLangBaseVisitor<Loop> {
    @Override
    public Loop visitForLoop(MiniGPLangParser.ForLoopContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        AntlrBlock blockVisitor = new AntlrBlock();
        Block block = new Block();

        return new Loop(((Variable) expressionVisitor.visit(ctx.getChild(2))).value,
                blockVisitor.visit(ctx.getChild(4)));

//        int loopRange = 0;
//        for (int i = 0; i < ctx.getChildCount(); i++){
//            if (ctx.getChild(i) instanceof MiniGPLangParser.VariableExpressionContext)
//                loopRange = ((Variable) expressionVisitor.visit(ctx.getChild(i))).value;
//            else if (ctx.getChild(i) instanceof MiniGPLangParser.BlockContext)
//                block = blockVisitor.visit(ctx.getChild(i));
//        }
//
//        return new Loop(loopRange, block);
    }

    @Override
    public Loop visitWhileLoop(MiniGPLangParser.WhileLoopContext ctx) {
        AntlrBoolStatement boolStatement = new AntlrBoolStatement();
        AntlrBlock commandBlock = new AntlrBlock();
        BoolStatement statement = boolStatement.visit(ctx.getChild(2));

        return new Loop(statement.satisfied, commandBlock.visit(ctx.getChild(4)));


//        for (int i = 0; i < ctx.getChildCount(); i++){
//            if (ctx.getChild(i) instanceof MiniGPLangParser.ExpressionBoolContext)
//                statement = boolStatement.visit(ctx.getChild(i));
//            else if (ctx.getChild(i) instanceof MiniGPLangParser.BlockContext)
//                block = commandBlock.visit(ctx.getChild(i));
//        }
//        return new Loop(statement.satisfied, block);
    }
}
