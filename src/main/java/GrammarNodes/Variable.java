package GrammarNodes;

public class Variable extends Node{

    public enum PossibleVariables {VARIABLE_NAME, NUMBER}
    public PossibleVariables rule;
    public String variableName;
    public int variableValue;
    public Variable(PossibleVariables rule, String variableName){
        this.rule = rule;
        this.variableName = variableName;
    }
    public Variable(PossibleVariables rule, int variableValue){
        this.rule = rule;
        this.variableValue = variableValue;
    }
    public String plot() {
        String output = "";
        switch (rule){
            case VARIABLE_NAME -> output += variableName;
            case NUMBER -> output += variableValue;
        }
        return output;
    }
}
