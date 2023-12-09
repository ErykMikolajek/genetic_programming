// Generated from MiniGPLang.g4 by ANTLR 4.13.1
package Interpreter;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniGPLangParser}.
 */
public interface MiniGPLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link MiniGPLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniGPLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link MiniGPLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniGPLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandLoop}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandLoop(MiniGPLangParser.CommandLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandLoop}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandLoop(MiniGPLangParser.CommandLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandIfStatement}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandIfStatement(MiniGPLangParser.CommandIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandIfStatement}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandIfStatement(MiniGPLangParser.CommandIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandExpression}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandExpression(MiniGPLangParser.CommandExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandExpression}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandExpression(MiniGPLangParser.CommandExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandAssign}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandAssign(MiniGPLangParser.CommandAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandAssign}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandAssign(MiniGPLangParser.CommandAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommandOutput}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommandOutput(MiniGPLangParser.CommandOutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommandOutput}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommandOutput(MiniGPLangParser.CommandOutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link MiniGPLangParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(MiniGPLangParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link MiniGPLangParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(MiniGPLangParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MiniGPLangParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(MiniGPLangParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MiniGPLangParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(MiniGPLangParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniGPLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniGPLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniGPLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniGPLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniGPLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniGPLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniGPLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniGPLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionOperatorExpression}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOperatorExpression(MiniGPLangParser.ExpressionOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionOperatorExpression}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOperatorExpression(MiniGPLangParser.ExpressionOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionBool}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBool(MiniGPLangParser.ExpressionBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionBool}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBool(MiniGPLangParser.ExpressionBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolOperatorBool}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperatorBool(MiniGPLangParser.BoolOperatorBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolOperatorBool}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperatorBool(MiniGPLangParser.BoolOperatorBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniGPLangParser#assignVariable}.
	 * @param ctx the parse tree
	 */
	void enterAssignVariable(MiniGPLangParser.AssignVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniGPLangParser#assignVariable}.
	 * @param ctx the parse tree
	 */
	void exitAssignVariable(MiniGPLangParser.AssignVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionSubstraction}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionSubstraction(MiniGPLangParser.AdditionSubstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionSubstraction}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionSubstraction(MiniGPLangParser.AdditionSubstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(MiniGPLangParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(MiniGPLangParser.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationDivision}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationDivision(MiniGPLangParser.MultiplicationDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationDivision}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationDivision(MiniGPLangParser.MultiplicationDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InputExpression}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(MiniGPLangParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InputExpression}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(MiniGPLangParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniGPLangParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(MiniGPLangParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniGPLangParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(MiniGPLangParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniGPLangParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(MiniGPLangParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniGPLangParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(MiniGPLangParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableGet}
	 * labeled alternative in {@link MiniGPLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariableGet(MiniGPLangParser.VariableGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableGet}
	 * labeled alternative in {@link MiniGPLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariableGet(MiniGPLangParser.VariableGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberGet}
	 * labeled alternative in {@link MiniGPLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterNumberGet(MiniGPLangParser.NumberGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberGet}
	 * labeled alternative in {@link MiniGPLangParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitNumberGet(MiniGPLangParser.NumberGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link MiniGPLangParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(MiniGPLangParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link MiniGPLangParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(MiniGPLangParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link MiniGPLangParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(MiniGPLangParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link MiniGPLangParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(MiniGPLangParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonLess}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonLess(MiniGPLangParser.ComparisonLessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonLess}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonLess(MiniGPLangParser.ComparisonLessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonGreater}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonGreater(MiniGPLangParser.ComparisonGreaterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonGreater}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonGreater(MiniGPLangParser.ComparisonGreaterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonEqual}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonEqual(MiniGPLangParser.ComparisonEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonEqual}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonEqual(MiniGPLangParser.ComparisonEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonNotEqual}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonNotEqual(MiniGPLangParser.ComparisonNotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonNotEqual}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonNotEqual(MiniGPLangParser.ComparisonNotEqualContext ctx);
}