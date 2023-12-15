package GrammarNodes;

import java.util.ArrayList;
public class Loop extends Node {

    public enum PossibleLoops {FOR, WHILE}

    public PossibleLoops rule;
//    public ArrayList<Node> children;
    public Node statementExpressionChild;

    public Loop(PossibleLoops loopRule, Node child, ArrayList<Node> childBlock){
        this.rule = loopRule;
        this.statementExpressionChild = child;
        this.children = childBlock;
    }

    public String plot(){
        StringBuilder output = new StringBuilder();
        switch (rule){
            case FOR -> output.append("\nfor (").append(statementExpressionChild.plot()).append(") {\n");
            case WHILE -> output.append("\nwhile (").append(statementExpressionChild.plot()).append(") {\n");
        }
        for (Node n : children)
            output.append("\t").append(n.plot());
        output.append("\n}\n");
        return output.toString();
    }

    @Override
    public String getSuperClass() {
        return "Loop";
    }

}
