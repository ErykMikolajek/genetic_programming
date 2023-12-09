package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AntlrBlock extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitBlock(MiniGPLangParser.BlockContext ctx) {
        AntlrCommand commandVisitor = new AntlrCommand();
        for (int i = 1; i < ctx.getChildCount() - 1; i++)
            if (!(ctx.getChild(i) instanceof TerminalNode))
                commandVisitor.visit(ctx.getChild(i));

        return null;
    }
}
