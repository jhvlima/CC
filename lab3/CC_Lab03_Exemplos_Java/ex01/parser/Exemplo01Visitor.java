// Generated from Exemplo01.g by ANTLR 4.13.2

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Exemplo01Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Exemplo01Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Exemplo01Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Exemplo01Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Exemplo01Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(Exemplo01Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link Exemplo01Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(Exemplo01Parser.FactorContext ctx);
}