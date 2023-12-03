package GrammarNodes;

import java.util.ArrayList;
import java.util.Arrays;

public class LogicalOperator extends Node{
    public enum PossibleLogicalOperators {AND, OR}

    public PossibleLogicalOperators rule;
    public ArrayList<Node> children;
    public LogicalOperator(PossibleLogicalOperators rule, Node child1, Node child2){
        this.rule = rule;
        this.children = new ArrayList<>(Arrays.asList(child1, child2));
    }
    public String plot(){
        if (children == null || children.size() < 2) return "";
        String output = children.get(0).plot();
        switch (rule){
            case AND -> output += " && ";
            case OR -> output += " || ";
        }
        output += children.get(1).plot();
        return output;
    }
}
