// Generated from Calculadora.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculadoraParser}.
 */
public interface CalculadoraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculadoraParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CalculadoraParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculadoraParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CalculadoraParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculadoraParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CalculadoraParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculadoraParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CalculadoraParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculadoraParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CalculadoraParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculadoraParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CalculadoraParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculadoraParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(CalculadoraParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculadoraParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(CalculadoraParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculadoraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalculadoraParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculadoraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalculadoraParser.ExprContext ctx);
}