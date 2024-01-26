package GrammarNodes;

import java.util.ArrayList;

public class ProgramNode extends Node{
//    public ArrayList<Node> children;

    public ProgramNode(ArrayList<Node> children) {
        this.children = children;
    }

    public String plot(){
        StringBuilder output = new StringBuilder();
        for (Node n : children){
            if (n != null)
                output.append(n.plot()).append("\n");
        }
        return output.toString();
    }

    public ProgramNode copy(){
        ArrayList<Node> childrenCopy = new ArrayList<>();
        for (Node n : children)
            childrenCopy.add(n.copy());
        return new ProgramNode(
                childrenCopy
        );
    }

    @Override
    public String getSuperClass() {
        return "ProgramNode";
    }
}
