package GrammarNodes;

public class Output extends Node{
//    public Node child;
    public Output(Node child){
        this.child = child;
    }

    public String plot(){
        return "output " + child.plot();
    }

    @Override
    public String getSuperClass() {
        return "Output";
    }
}
