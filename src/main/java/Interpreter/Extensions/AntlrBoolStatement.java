package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrBoolStatement extends MiniGPLangBaseVisitor<BoolStatement> {
    @Override
    public BoolStatement visitExpressionOperatorExpression(MiniGPLangParser.ExpressionOperatorExpressionContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        int left = ((Variable) expressionVisitor.visit(ctx.expression(0))).value;
        int right = ((Variable) expressionVisitor.visit(ctx.expression(1))).value;

        AntlrComparisonOperator comparisonOperatorVisitor = new AntlrComparisonOperator();
        ComparisonOperator operator = comparisonOperatorVisitor.visit(ctx.comparisonOperator());
        BoolStatement returnStatement = new BoolStatement();
        switch (operator) {
            case LESS -> returnStatement.satisfied = left < right;
            case GREATER -> returnStatement.satisfied = left > right;
            case EQUAL -> returnStatement.satisfied = left == right;
            case NOT_EQUAL -> returnStatement.satisfied = left != right;
        }
        return returnStatement;
    }

    @Override
    public BoolStatement visitExpressionBool(MiniGPLangParser.ExpressionBoolContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        return new BoolStatement(expressionVisitor.visit(ctx.expression()));
    }

    @Override
    public BoolStatement visitBoolOperatorBool(MiniGPLangParser.BoolOperatorBoolContext ctx) {
        AntlrBoolStatement antlrBoolStatementVisitor = new AntlrBoolStatement();
        AntlrLogicalOperator antlrLogicalOperatorVisitor = new AntlrLogicalOperator();

        BoolStatement left = antlrBoolStatementVisitor.visit(ctx.boolStatement(0));
        BoolStatement right = antlrBoolStatementVisitor.visit(ctx.boolStatement(1));

        BoolStatement returnStatement = new BoolStatement();

        LogicalOperator operator = antlrLogicalOperatorVisitor.visit(ctx.logicalOperator());

        switch (operator){
            case AND -> returnStatement.satisfied = left.satisfied && right.satisfied;
            case OR -> returnStatement.satisfied = left.satisfied || right.satisfied;
        }

        return returnStatement;
    }
}
