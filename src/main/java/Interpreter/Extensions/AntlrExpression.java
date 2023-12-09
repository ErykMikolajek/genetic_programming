package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.util.Objects;

public class AntlrExpression extends MiniGPLangBaseVisitor<Expression> {
    @Override
    public Expression visitAdditionSubstraction(MiniGPLangParser.AdditionSubstractionContext ctx) {
        AntlrExpression x = new AntlrExpression();

        Variable l = (Variable) x.visit(ctx.getChild(0));
        Variable r = (Variable) x.visit(ctx.getChild(2));

        String character = ctx.getChild(1).getText();
        if (Objects.equals(character, "+")){
            return new Variable(l.value + r.value);
        }
        else if (Objects.equals(character, "-")){
            return new Variable(l.value - r.value);
        }
        else return null;
    }

    @Override
    public Expression visitVariableExpression(MiniGPLangParser.VariableExpressionContext ctx) {
        AntlrVariable variableVisitor = new AntlrVariable();
        return variableVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Expression visitInputExpression(MiniGPLangParser.InputExpressionContext ctx) {
        AntlrInput inputVisitor = new AntlrInput();
        return inputVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Expression visitMultiplicationDivision(MiniGPLangParser.MultiplicationDivisionContext ctx) {
        AntlrExpression x = new AntlrExpression();

        Variable l = (Variable) x.visit(ctx.getChild(0));
        Variable r = (Variable) x.visit(ctx.getChild(2));

        String character = ctx.getChild(1).getText();
        if (Objects.equals(character, "*")){
            return new Variable(l.value * r.value);
        }
        else if (Objects.equals(character, "/")){
            int position = ctx.start.getCharPositionInLine() + 1;
            if (r.value == 0) {}// TODO: handle null division
            return new Variable(l.value / r.value);
        }
        else return null;
    }
}
