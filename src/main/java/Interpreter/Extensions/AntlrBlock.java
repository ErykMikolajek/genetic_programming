package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrBlock extends MiniGPLangBaseVisitor<Block> {
    @Override
    public Block visitBlock(MiniGPLangParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }
}
