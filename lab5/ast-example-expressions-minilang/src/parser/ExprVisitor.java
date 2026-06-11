// Generated from Expr.g4 by ANTLR 4.13.2
 package parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStatement}
	 * labeled alternative in {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(ExprParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(ExprParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(ExprParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpression(ExprParser.IdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(ExprParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentheticExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheticExpression(ExprParser.ParentheticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpression(ExprParser.MulDivExpressionContext ctx);
}