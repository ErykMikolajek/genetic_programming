package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrBoolStatement extends MiniGPLangBaseVisitor<BoolStatement> {
    @Override
    public BoolStatement visitExpressionOperatorExpression(MiniGPLangParser.ExpressionOperatorExpressionContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        Expression left = expressionVisitor.visit(ctx.getChild(0));
        Expression right = expressionVisitor.visit(ctx.getChild(2));

        int leftValue = ((Variable) left).value;
        int rightValue = ((Variable) right).value;

        AntlrComparisonOperator comparisonOperatorVisitor = new AntlrComparisonOperator();
        ComparisonOperator operator = comparisonOperatorVisitor.visit(ctx.getChild(1));
        BoolStatement returnStatement = new BoolStatement();
        switch (operator) {
            case LESS -> returnStatement.satisfied = leftValue < rightValue;
            case GREATER -> returnStatement.satisfied = leftValue > rightValue;
            case EQUAL -> returnStatement.satisfied = leftValue == rightValue;
            case NOT_EQUAL -> returnStatement.satisfied = leftValue != rightValue;
        }

        return returnStatement;
    }

    @Override
    public BoolStatement visitExpressionBool(MiniGPLangParser.ExpressionBoolContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        Variable var = (Variable) expressionVisitor.visit(ctx.getChild(0));
        return new BoolStatement(var);
    }

    @Override
    public BoolStatement visitBoolOperatorBool(MiniGPLangParser.BoolOperatorBoolContext ctx) {
        AntlrBoolStatement antlrBoolStatementVisitor = new AntlrBoolStatement();
        AntlrLogicalOperator antlrLogicalOperatorVisitor = new AntlrLogicalOperator();

        BoolStatement left = antlrBoolStatementVisitor.visit(ctx.getChild(0));
        BoolStatement right = antlrBoolStatementVisitor.visit(ctx.getChild(2));

        BoolStatement returnStatement = new BoolStatement();

        LogicalOperator operator = antlrLogicalOperatorVisitor.visit(ctx.getChild(1));

        switch (operator){
            case AND -> returnStatement.satisfied = left.satisfied && right.satisfied;
            case OR -> returnStatement.satisfied = left.satisfied || right.satisfied;
        }

        return returnStatement;
    }
}
