// Generated from MiniGPLang.g4 by ANTLR 4.13.1
package Interpreter;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniGPLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniGPLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link MiniGPLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniGPLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandLoop}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandLoop(MiniGPLangParser.CommandLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandIfStatement}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandIfStatement(MiniGPLangParser.CommandIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandExpression}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandExpression(MiniGPLangParser.CommandExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandAssign}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandAssign(MiniGPLangParser.CommandAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommandOutput}
	 * labeled alternative in {@link MiniGPLangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandOutput(MiniGPLangParser.CommandOutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link MiniGPLangParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(MiniGPLangParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MiniGPLangParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(MiniGPLangParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniGPLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniGPLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniGPLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniGPLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionOperatorExpression}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOperatorExpression(MiniGPLangParser.ExpressionOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBool}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBool(MiniGPLangParser.ExpressionBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolOperatorBool}
	 * labeled alternative in {@link MiniGPLangParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperatorBool(MiniGPLangParser.BoolOperatorBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniGPLangParser#assignVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVariable(MiniGPLangParser.AssignVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionSubstraction}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionSubstraction(MiniGPLangParser.AdditionSubstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(MiniGPLangParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationDivision}
	 * labeled alternative in {@link MiniGPLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationDivision(MiniGPLangParser.MultiplicationDivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniGPLangParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(MiniGPLangParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableGet}
	 * labeled alternative in {@link MiniGPLangParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableGet(MiniGPLangParser.VariableGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberGet}
	 * labeled alternative in {@link MiniGPLangParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberGet(MiniGPLangParser.NumberGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link MiniGPLangParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(MiniGPLangParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link MiniGPLangParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(MiniGPLangParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonLess}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonLess(MiniGPLangParser.ComparisonLessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonGreater}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonGreater(MiniGPLangParser.ComparisonGreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonEqual}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonEqual(MiniGPLangParser.ComparisonEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonNotEqual}
	 * labeled alternative in {@link MiniGPLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonNotEqual(MiniGPLangParser.ComparisonNotEqualContext ctx);
}