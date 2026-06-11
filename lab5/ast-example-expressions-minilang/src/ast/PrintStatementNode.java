package ast;

public class PrintStatementNode extends StatementNode {

    private Variable var;

    public PrintStatementNode(Variable var) {
        this.var = var;
    }

    public Variable getVariable() {
        return this.var;
    }
    
}
