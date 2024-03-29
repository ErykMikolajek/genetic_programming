package GrammarNodes;

import java.util.ArrayList;
import java.util.Arrays;

public class LogicalOperator extends Node{
    public enum PossibleLogicalOperators {AND, OR}

    public PossibleLogicalOperators rule;
//    public ArrayList<Node> children;
    public LogicalOperator(PossibleLogicalOperators rule, Node child1, Node child2){
        this.rule = rule;
        this.children = new ArrayList<>(Arrays.asList(child1, child2));
    }
    public String plot(){
        String output = children.get(0).plot();
        switch (rule){
            case AND -> output += " && ";
            case OR -> output += " || ";
        }
        output += children.get(1).plot();
        return output;
    }

    public LogicalOperator copy(){
        return new LogicalOperator(
          this.rule, this.children.get(0).copy(), this.children.get(1).copy()
        );
    }

    @Override
    public String getSuperClass() {
        return "LogicalOperator";
    }
}
