package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AntlrBlock extends MiniGPLangBaseVisitor<Block> {
    @Override
    public Block visitBlock(MiniGPLangParser.BlockContext ctx) {
        AntlrCommand commandVisitor = new AntlrCommand();
        Block block = new Block();
        for (int i = 1; i < ctx.getChildCount() - 1; i++)
        {
            if (!(ctx.getChild(i) instanceof TerminalNode)){
                Command com = commandVisitor.visit(ctx.getChild(i));
                block.addCommand(com);
            }
        }

        return block;
    }
}
