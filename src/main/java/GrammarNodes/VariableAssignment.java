package GrammarNodes;

public class VariableAssignment extends Node{
//    public Node child;
    public String variableName;
    public VariableAssignment(Node child, String variableName){
        this.child = child;
        this.variableName = variableName;
    }

    public String plot(){
        return variableName + " = " + child.plot() + " ";
    }

    @Override
    public String getSuperClass() {
        return "VariableAssignment";
    }
}
