package GrammarNodes;

import java.util.ArrayList;
import java.util.Arrays;

public class Expression extends Node{
    public enum PossibleExpressions {
        MUL, DIV, ADD, SUB, VARIABLE
    }

    public PossibleExpressions rule;
    public ArrayList<Node> children;
    public Expression(PossibleExpressions rule, Node child1, Node child2){
        this.rule = rule;
        this.children = new ArrayList<>(Arrays.asList(child1, child2));
    }
    public String plot() {
        if (children == null || children.size() < 2) return "";
        String output = "";
        switch (rule) {
            case MUL -> output += children.get(0).plot() + " * " + children.get(1).plot();
            case DIV -> output += children.get(0).plot() + " / " + children.get(1).plot();
            case ADD -> output += children.get(0).plot() + " + " + children.get(1).plot();
            case SUB -> output += children.get(0).plot() + " - " + children.get(1).plot();
            case VARIABLE -> output += children.get(0).plot();
        }
        return output;
    }
}
