package GrammarNodes;

import java.util.ArrayList;

public abstract class Node {
    public ArrayList<Node> children;

    public abstract String plot();
}
