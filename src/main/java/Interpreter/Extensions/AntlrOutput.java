package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrOutput extends MiniGPLangBaseVisitor<Output> {
    @Override
    public Output visitOutput(MiniGPLangParser.OutputContext ctx) {

        return super.visitOutput(ctx);
    }
}
