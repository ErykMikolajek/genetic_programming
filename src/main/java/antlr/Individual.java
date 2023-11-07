package antlr;

import java.util.Random;

public class Individual {
    Node head = new Node(null, null, null);
    Node last_child = head;
    int MAX_RANDOM_VALUE = 100;
    int MIN_RANDOM_VALUE = 0;
    static Random random = new Random();
    Node generateIndividual(int maxDepth){
        PossibleExpressions[] enumValues = PossibleExpressions.values();
        PossibleExpressions randomExpression = enumValues[random.nextInt(enumValues.length)];

        Node newNode = null;
        if (maxDepth == 1) {
            newNode = new Node(PossibleExpressions.VARIABLE, null, last_child,
                    random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE));
            return newNode;
        }
        else {
            switch (randomExpression) {
                case MUL -> newNode = new Node(PossibleExpressions.MUL, null, last_child);
                case DIV -> newNode = new Node(PossibleExpressions.DIV, null, last_child);
                case ADD -> newNode = new Node(PossibleExpressions.ADD, null, last_child);
                case SUB -> newNode = new Node(PossibleExpressions.SUB, null, last_child);
                case VARIABLE -> {
                    newNode = new Node(PossibleExpressions.VARIABLE, null, last_child,
                            random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE));
                    if (last_child == head) {
                        head.children_ = new Node[]{newNode};
                    }
                    return newNode;
                }
            }
            if (last_child == head){
                head.children_ = new Node[]{newNode};
            }
            last_child = newNode;
            Node child1 = generateIndividual(maxDepth - 1);
            Node child2 = generateIndividual(maxDepth - 1);
            newNode.children_ = new Node[]{child1, child2};
            return newNode;
        }
    }

    void selfRepresent(Node node){
        if (node.parent_ == null) {
            node = node.children_[0];
        }

        if (node.children_ == null) {
            System.out.print(node.value_);
            return;
        }

        if (node.expression_ == null) {
            selfRepresent(node.children_[0]);
            System.out.print(node.value_);
        }
        else {
            System.out.print("(");
            selfRepresent(node.children_[0]);
            switch (node.expression_){
                case MUL -> System.out.print("*");
                case DIV -> System.out.print("/");
                case ADD -> System.out.print("+");
                case SUB -> System.out.print("-");
            }
            selfRepresent(node.children_[1]);
            System.out.print(")");
        }
    }
}
