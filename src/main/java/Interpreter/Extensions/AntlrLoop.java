package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrLoop extends MiniGPLangBaseVisitor<Loop> {
    @Override
    public Loop visitForLoop(MiniGPLangParser.ForLoopContext ctx) {
        return super.visitForLoop(ctx);
    }

    @Override
    public Loop visitWhileLoop(MiniGPLangParser.WhileLoopContext ctx) {
        return super.visitWhileLoop(ctx);
    }
}
