package GrammarNodes;

public class Output extends Node{
//    public Node child;
    public Output(Node child){
        this.child = child;
    }

    public String plot(){
        return "output " + child.plot();
    }
    public Output copy(){
        return new Output(this.child.copy());
    }

    @Override
    public String getSuperClass() {
        return "Output";
    }
}
