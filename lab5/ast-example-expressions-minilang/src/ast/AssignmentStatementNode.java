package ast;

public class AssignmentStatementNode extends StatementNode {
    private Variable assignedVariable;
    private ExprNode expression;

    public AssignmentStatementNode(Variable assignedVariable, ExprNode expression) {
        this.assignedVariable = assignedVariable;
        this.expression = expression;
    }

    public Variable getAssignedVariable() {
        return assignedVariable;
    }
    public ExprNode getExpression() {
        return expression;
    }

}
