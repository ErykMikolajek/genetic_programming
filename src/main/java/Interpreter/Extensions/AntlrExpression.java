package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.util.Objects;

public class AntlrExpression extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitAdditionSubstraction(MiniGPLangParser.AdditionSubstractionContext ctx) {
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
    public Command visitVariableExpression(MiniGPLangParser.VariableExpressionContext ctx) {
        AntlrVariable variableVisitor = new AntlrVariable();
        return variableVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitInputExpression(MiniGPLangParser.InputExpressionContext ctx) {
        AntlrInput inputVisitor = new AntlrInput();
        return inputVisitor.visit(ctx.getChild(0));
    }

    @Override
    public Command visitMultiplicationDivision(MiniGPLangParser.MultiplicationDivisionContext ctx) {
        AntlrExpression x = new AntlrExpression();

        Variable l = (Variable) x.visit(ctx.getChild(0));
        Variable r = (Variable) x.visit(ctx.getChild(2));

        String character = ctx.getChild(1).getText();
        if (Objects.equals(character, "*")){
            return new Variable(l.value * r.value);
        }
        else if (Objects.equals(character, "/")){
            if (r.value == 0)
                throw new BadProgramException("RuntimeException: Division by Zero\n" +
                        "The program encountered an attempt to divide by zero.");
            return new Variable(l.value / r.value);
        }
        else return null;
    }
}
