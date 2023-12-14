package GrammarNodes;

import java.util.ArrayList;
public class IfStatement extends Node{

    public boolean hasElse;
    public Node childBoolStatement;
//    public ArrayList<Node> childrenBlock1;
//    public ArrayList<Node> childrenBlock2;

    public IfStatement(boolean hasElse, Node child1, ArrayList<Node> childBlock1){
        this.childBoolStatement = child1;
        this.childrenBlock1 = childBlock1;
        this.hasElse = hasElse;
    }

    public IfStatement(boolean hasElse, Node child1, ArrayList<Node> childBlock1, ArrayList<Node> childBlock2){
        this.childBoolStatement = child1;
        this.childrenBlock1 = childBlock1;
        this.childrenBlock2 = childBlock2;
        this.hasElse = hasElse;
    }

    public String plot(){
        StringBuilder output = new StringBuilder("\nif (" + childBoolStatement.plot() + ") {\n");
        for (Node n : childrenBlock1)
            output.append("\t").append(n.plot());
        output.append("\n}\n");
        if (hasElse) {
            output.append("\nelse {\n");
            for (Node n : childrenBlock2)
                output.append("\t").append(n.plot());
            output.append("\n}\n");
        }
        return output.toString();
    }
}
