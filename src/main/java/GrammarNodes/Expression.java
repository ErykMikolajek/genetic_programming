package GrammarNodes;

import java.util.ArrayList;
import java.util.Arrays;

public class Expression extends Node{
    public enum PossibleExpressions {
        MUL, DIV, ADD, SUB, VARIABLE, INPUT
    }

    public PossibleExpressions rule;
//    public ArrayList<Node> children;
    public Expression(PossibleExpressions rule, Node child1, Node child2){
        this.rule = rule;
        this.children = new ArrayList<>(Arrays.asList(child1, child2));
    }
    public String plot() {
        String output = "";
        switch (rule) {
            case MUL -> output += children.get(0).plot() + " * " + children.get(1).plot();
            case DIV -> output += children.get(0).plot() + " / " + children.get(1).plot();
            case ADD -> output += children.get(0).plot() + " + " + children.get(1).plot();
            case SUB -> output += children.get(0).plot() + " - " + children.get(1).plot();
            case VARIABLE, INPUT -> output += children.get(0).plot();
        }
        return output;
    }

    @Override
    public String getSuperClass() {
        return "Expression";
    }
}
