package GrammarNodes;

public class VariableAssignment extends Node{
    public Node child;
    public String variableName;
    public VariableAssignment(Node child, String variableName){
        this.child = child;
        this.variableName = variableName;
    }

    public String plot(){
        if (child == null) return "";
        else return "\n" + variableName + " = " + child.plot() + "\n";
    }
}
