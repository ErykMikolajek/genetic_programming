package GrammarNodes;

public class Input extends Node{
    public String plot(){
        return "input ";
    }
    public Input copy(){
        return new Input();
    }
    @Override
    public String getSuperClass() {
        return "Input";
    }
}
