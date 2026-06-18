package interpreter;

import java.util.HashMap;
import java.util.Map;

import ast.*;

public class Interpreter {

    private Map<Variable,Integer> memory = new HashMap<>();

    public void evalProgram(ProgramNode node)
    {
        for(StatementNode s : node.getStatements())
        {
            switch (s) {
                case PrintStatementNode psn -> {
                    System.out.println("[DEBUG] Printing "+psn.getVariable().getName());
                    int value = memory.get(psn.getVariable());
                    System.out.println(value);
                }
                case AssignmentStatementNode asn ->  {
                    System.out.println("[DEBUG] Assigning to "+asn.getAssignedVariable().getName());
                    int value = evalExpression(asn.getExpression());
                    memory.put(asn.getAssignedVariable(),value);
                }
                default -> {} 
            }
        }
    }

    public int evalExpression(ExprNode node) {
        return switch (node) {
            case IntNode n -> n.value;
            case AddNode n -> evalExpression(n.left) + evalExpression(n.right);
            case SubNode n -> evalExpression(n.left) - evalExpression(n.right);
            case MulNode n -> evalExpression(n.left) * evalExpression(n.right);
            case DivNode n -> evalExpression(n.left) / evalExpression(n.right);
            case IdExpressionNode n -> memory.get(n.getVariable());
            default -> throw new RuntimeException("Unknown AST node: " + node.getClass().getName());
        };
    }
}
