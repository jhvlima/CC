import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*;
import ast.*;
import interpreter.*;

public class Main {
    public static void main(String[] args) {
        String input = args.length > 0 ? args[0] :
            """
            x=((1+2)*(3))
            print x
            print x
            print x
            x=x-1
            print x
            print x
            """;
        CharStream cs = CharStreams.fromString(input);
        ExprLexer lexer = new ExprLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.program();

        // parsing concluído, vamos à construção da AST
        ASTBuilderVisitor astBuilder = new ASTBuilderVisitor();
        ProgramNode ast = (ProgramNode)astBuilder.visit(tree);

        // print AST
        printAST(ast, 0);

        // depois interpretação
        Interpreter interpreter = new Interpreter();
        interpreter.evalProgram(ast);
        
    }

    private static void printAST(ASTNode node, int indent) {
        String pad = "  ".repeat(indent);
        switch (node) {
            case ProgramNode pn -> {
                System.out.println(pad + "ProgramNode(");
                for(StatementNode sn : pn.getStatements())
                    printAST(sn, indent + 1);    
                System.out.println(pad + ")");
            }
            case PrintStatementNode pn -> 
                System.out.println(pad + "PrintStatementNode("+ pn.getVariable().getName() +")");
            case AssignmentStatementNode an -> 
            {
                System.out.println(pad + an.getClass().getSimpleName() + "(" + an.getAssignedVariable().getName());
                printAST(an.getExpression(), indent + 1);
                System.out.println(pad + ")");
            }
            case IntNode intNode ->
                System.out.println(pad + "IntNode(" + intNode.value + ")");
            case BinOpNode binOp -> {
                String op = binOp.getClass().getSimpleName();
                System.out.println(pad + op + "(");
                printAST(binOp.left, indent + 1);
                printAST(binOp.right, indent + 1);
                System.out.println(pad + ")");
            }
            default ->
                System.out.println(pad + node.getClass().getSimpleName());
        }
    }
}
