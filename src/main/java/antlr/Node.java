package antlr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

    public Node copy() {
        Node copyNode = new Node(this.expression_, null, null, this.value_);

        if (this.children_ != null) {
            copyNode.children_ = new Node[this.children_.length];
            for (int i = 0; i < this.children_.length; i++) {
                Node childCopy = this.children_[i].copy();
                childCopy.parent_ = copyNode;
                copyNode.children_[i] = childCopy;
            }
        }

        return copyNode;
    }

    public static Node copyTree(Node root) {
        if (root == null) {
            return null;
        }

        Node rootCopy = root.copy();
        rootCopy.parent_ = null;

        return rootCopy;
    }

    public int height() {
        int maxHeight = 0;

        if (this.children_ != null) {
            for (Node child : this.children_) {
                int childHeight = child.height();
                maxHeight = Math.max(maxHeight, childHeight);
            }
        }

        return 1 + maxHeight;
    }

    public static ArrayList<Node> getNodesAtLevel(Node root, int level) {
        ArrayList<Node> nodesAtLevel = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        int currentLevel = 0;

        if (root != null) {
            queue.add(root);

            while (!queue.isEmpty() && currentLevel < level) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();

                    assert node != null;
                    if (node.children_ != null) {
                        Collections.addAll(queue, node.children_);
                    }
                }

                currentLevel++;
            }

            while (!queue.isEmpty() && currentLevel == level) {
                nodesAtLevel.add(queue.poll());
            }
        }

        return nodesAtLevel;
    }

}
