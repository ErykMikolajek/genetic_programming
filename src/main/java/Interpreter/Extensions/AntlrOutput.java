package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrOutput extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitOutput(MiniGPLangParser.OutputContext ctx) {
        AntlrExpression expressionVisitor = new AntlrExpression();
//        AntlrProgram.programOutput += ((Variable) expressionVisitor.visit(ctx.getChild(1))).value + "\n";
        // TODO: program doesn't output when variable is 0
        AntlrProgram.programOutput.add(((Variable) expressionVisitor.visit(ctx.getChild(1))).value);
        return null;
    }
}
