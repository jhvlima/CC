package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramNode extends ASTNode {

    private Map<String,Variable> varTable = new HashMap<>();
    private List<StatementNode> statements = new ArrayList<>();

    public void putVariable(String name, Variable var)
    {
        varTable.put(name, var);
    }
    public Variable getVariable(String nome)
    {
        return varTable.get(nome);
    }

    public void addStatement(StatementNode child) {
        statements.add(child);
    }
    public List<StatementNode> getStatements()
    {
        return new ArrayList<>(statements);
    }
    
}
