package GrammarNodes;

import java.util.ArrayList;
import java.util.Arrays;

public class ComparisonOperator extends Node{
    public enum PossibleComparisonOperators {
        LESS,
        GREATER,
        EQUAL,
        NOT_EQUAL
    }
    public PossibleComparisonOperators rule;
    public ArrayList<Node> children;
    public ComparisonOperator(PossibleComparisonOperators rule, Node child1, Node child2){
        this.rule = rule;
        this.children = new ArrayList<>(Arrays.asList(child1, child2));
    }

    public String plot(){
        String output = children.get(0).plot();
        switch (rule){
            case LESS -> output += " < ";
            case GREATER -> output += " > ";
            case EQUAL -> output += " == ";
            case NOT_EQUAL -> output += " != ";
        }
        output += children.get(1).plot();
        return output;
    }
}
