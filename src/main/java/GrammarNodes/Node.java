package GrammarNodes;

import java.util.ArrayList;

public abstract class Node {

    public ArrayList<Node> children = new ArrayList<>();
    public ArrayList<Node> childrenBlock1 = new ArrayList<>();
    public ArrayList<Node> childrenBlock2 = new ArrayList<>();
    public Node child = null;

    public abstract String plot();
}
