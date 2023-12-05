package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrAssignVariable extends MiniGPLangBaseVisitor<AssignVariable> {
    @Override
    public AssignVariable visitAssignVariable(MiniGPLangParser.AssignVariableContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        int variableValue = ((Variable) expressionVisitor.visit(ctx.getChild(2))).value;
        VariablesTable.addVariable(ctx.getChild(0).getText(), variableValue);
        return new AssignVariable();
    }
}
