package Interpreter.Extensions;

import Interpreter.MiniGPLangBaseVisitor;
import Interpreter.MiniGPLangParser;

public class AntlrComparisonOperator extends MiniGPLangBaseVisitor<ComparisonOperator> {
    @Override
    public ComparisonOperator visitComparisonLess(MiniGPLangParser.ComparisonLessContext ctx) {
        return ComparisonOperator.LESS;
    }

    @Override
    public ComparisonOperator visitComparisonGreater(MiniGPLangParser.ComparisonGreaterContext ctx) {
        return ComparisonOperator.GREATER;
    }

    @Override
    public ComparisonOperator visitComparisonEqual(MiniGPLangParser.ComparisonEqualContext ctx) {
        return ComparisonOperator.EQUAL;
    }

    @Override
    public ComparisonOperator visitComparisonNotEqual(MiniGPLangParser.ComparisonNotEqualContext ctx) {
        return ComparisonOperator.NOT_EQUAL;
    }
}
