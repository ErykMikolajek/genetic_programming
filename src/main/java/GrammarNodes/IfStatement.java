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
        StringBuilder output = new StringBuilder("if (" + childBoolStatement.plot() + ") { ");
        for (Node n : childrenBlock1)
            output.append(n.plot());
        output.append(" } ");
        if (hasElse) {
            output.append("else { ");
            for (Node n : childrenBlock2)
                output.append(n.plot());
            output.append(" } ");
        }
        return output.toString();
    }

    @Override
    public String getSuperClass() {
        return "IfStatement";
    }

}
