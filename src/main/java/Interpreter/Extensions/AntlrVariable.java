package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrVariable extends MiniGPLangBaseVisitor<Variable> {
    @Override
    public Variable visitVariableGet(MiniGPLangParser.VariableGetContext ctx) {
        String varName = ctx.getChild(0).getText();
        int f = VariablesTable.getVariableValue(varName);
        return new Variable(VariablesTable.getVariableValue(varName));
    }

    @Override
    public Variable visitNumberGet(MiniGPLangParser.NumberGetContext ctx) {
        String numText = ctx.getChild(0).getText();
        return new Variable(Integer.parseInt(numText));
    }
}
