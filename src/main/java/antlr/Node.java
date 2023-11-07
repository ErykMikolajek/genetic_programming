package antlr;

public class Node {

    public PossibleExpressions expression_;
    public int value_;
    Node[] children_;
    Node parent_;

    Node(PossibleExpressions expression, Node[] children, Node parent){
        expression_ = expression;
        children_ = children;
        parent_ = parent;
        value_ = -1;
    }
    Node(PossibleExpressions expression, Node[] children, Node parent, int value){
        expression_ = expression;
        children_ = children;
        parent_ = parent;
        value_ = value;
    }
}
