package ast;

public abstract class BinOpNode extends ExprNode {
    public final ExprNode left;
    public final ExprNode right;
    public BinOpNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
    }
}
