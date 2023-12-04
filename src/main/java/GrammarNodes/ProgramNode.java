package GrammarNodes;

import java.util.ArrayList;

public class ProgramNode extends Node{
    public ArrayList<Node> children;

    public ProgramNode(ArrayList<Node> children) {
        this.children = children;
    }

    public String plot(){
        StringBuilder output = new StringBuilder();
        for (Node n : children){
            if (n != null)
//                output.append(n.plot()).append("\n");
                output.append(n.plot());
        }
        return output.toString();
    }
}
