package GrammarNodes;

import java.util.ArrayList;
public class Loop extends Node {

    public enum PossibleLoops {FOR, WHILE}

    public PossibleLoops rule;
    public ArrayList<Node> childrenBlock;
    public Node statementExpressionChild;

    public Loop(PossibleLoops loopRule, Node child, ArrayList<Node> childBlock){
        this.rule = loopRule;
        this.statementExpressionChild = child;
        this.childrenBlock = childBlock;
    }

    public String plot(){
        if (statementExpressionChild == null || childrenBlock == null || childrenBlock.size() < 2) return "";
        StringBuilder output = new StringBuilder();
        switch (rule){
            case FOR -> output.append("\nfor (").append(statementExpressionChild.plot()).append(") {\n");
            case WHILE -> output.append("\nwhile (").append(statementExpressionChild.plot()).append(") {\n");
        }
        for (Node n : childrenBlock)
            output.append("\t").append(n.plot());
        output.append("\n}\n");
        return output.toString();
    }

}
