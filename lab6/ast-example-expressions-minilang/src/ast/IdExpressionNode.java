package ast;

public class IdExpressionNode extends ExprNode {
    private Variable var;

    public IdExpressionNode(Variable var)
    {
        this.var=var;
    }

    public Variable getVariable()
    {
        return this.var;
    }
}
