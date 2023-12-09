package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrAssignVariable extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitAssignVariable(MiniGPLangParser.AssignVariableContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
        VariablesTable.addVariable(ctx.getChild(0).getText(), ((Variable) expressionVisitor.visit(ctx.getChild(2))).value);
        return null;
    }
}
