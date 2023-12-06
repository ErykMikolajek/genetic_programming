package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

import java.util.Objects;

public class AntlrIfStatement extends MiniGPLangBaseVisitor<IfStatement> {
    @Override
    public IfStatement visitIfStatement(MiniGPLangParser.IfStatementContext ctx) {
        AntlrBoolStatement boolStatementVisitor = new AntlrBoolStatement();
        AntlrBlock commandBlockVisitor = new AntlrBlock();
        BoolStatement statement = null;
        Block blockIf = null;
        Block blockElse = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            String instruction = ctx.getChild(i).getText();
            switch (instruction) {
                case "if" -> {
                    statement = boolStatementVisitor.visit(ctx.getChild(i + 2));
                    blockIf = commandBlockVisitor.visit(ctx.getChild(i + 4));
                }
                case "else" -> blockElse = commandBlockVisitor.visit(ctx.getChild(i + 1));
            }
        }
        assert statement != null;
        return new IfStatement(blockIf, statement.satisfied, blockElse);
    }
}
