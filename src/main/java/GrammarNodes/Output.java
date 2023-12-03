package GrammarNodes;

public class Output extends Node{
    public Node child;
    public Output(Node child){
        this.child = child;
    }

    public String plot(){
        if (child == null) return "";
        else return "output " + child.plot();
    }
}
