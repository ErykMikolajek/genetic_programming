package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.util.Objects;

public class AntlrIfStatement extends MiniGPLangBaseVisitor<Command> {
    @Override
    public Command visitIfStatement(MiniGPLangParser.IfStatementContext ctx) {
        AntlrBoolStatement boolStatementVisitor = new AntlrBoolStatement();
        AntlrBlock commandBlockVisitor = new AntlrBlock();

        if (boolStatementVisitor.visit(ctx.boolStatement()).satisfied) commandBlockVisitor.visit(ctx.block(0));
        else if (ctx.block(1) != null)
                commandBlockVisitor.visit(ctx.block(1));

        return null;
    }
}
