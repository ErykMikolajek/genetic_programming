package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrLogicalOperator extends MiniGPLangBaseVisitor<LogicalOperator> {
    @Override
    public LogicalOperator visitLogicalAnd(MiniGPLangParser.LogicalAndContext ctx) {return LogicalOperator.AND;}
    @Override
    public LogicalOperator visitLogicalOr(MiniGPLangParser.LogicalOrContext ctx) {return LogicalOperator.OR;}
}
