package ast;
import parser.*;
import parser.ExprParser.StatementContext;

public class ASTBuilderVisitor extends ExprBaseVisitor<ASTNode> {

    ProgramNode program;

	@Override
    public ProgramNode visitProgram(ExprParser.ProgramContext ctx) { 
        program = new ProgramNode();
        for (StatementContext sc : ctx.statement())
        {
            program.addStatement((StatementNode)visit(sc));
        }
        return program;
     }

    // StatementNodes

	@Override 
    public PrintStatementNode visitPrintStatement(ExprParser.PrintStatementContext ctx) { 
        Variable var = program.getVariable(ctx.ID().getText());
        if (var==null) { 
            System.err.println("Uninitialized variable "+ctx.ID().getText()+ " at line "+ctx.start.getLine());
            System.exit(1); }
        return new PrintStatementNode(var); 
    }
	
    @Override 
    public AssignmentStatementNode visitAssignmentStatement(ExprParser.AssignmentStatementContext ctx) { 
        // visit expression first, because we want to detect errors such as x=x+1 when x is not yet initialized
        ExprNode expression = (ExprNode)visit(ctx.expr());
        Variable v = new Variable(ctx.ID().getText());
        program.putVariable(v.getName(),v);
        return new AssignmentStatementNode(v,expression); 
    }

    // ExprNodes

    @Override
    public ExprNode visitIntLiteral(ExprParser.IntLiteralContext ctx) {
        return new IntNode(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
	public ExprNode visitIdExpression(ExprParser.IdExpressionContext ctx) { 
        Variable var = program.getVariable(ctx.ID().getText());
        if (var==null) { 
            System.err.println("Uninitialized variable "+ctx.ID().getText()+ " at line "+ctx.start.getLine());
            System.exit(1); }
        return new IdExpressionNode(var);
    }

    @Override
    public ExprNode visitAddSubExpression(ExprParser.AddSubExpressionContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));
        if (ctx.op.getType()==ExprLexer.ADD)
            return new AddNode(left, right);
        else
            return new SubNode(left, right);
    }

    @Override
    public ExprNode visitMulDivExpression(ExprParser.MulDivExpressionContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));
        if (ctx.op.getType()==ExprLexer.MUL)
            return new MulNode(left, right);
        else 
            return new DivNode(left,right);
    }

    @Override
    public ExprNode visitParentheticExpression(ExprParser.ParentheticExpressionContext ctx) {
        return (ExprNode)visit(ctx.expr());
    }
}
