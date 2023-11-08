package antlr;

import java.util.Random;

import static antlr.Node.copyTree;
import static antlr.Node.getNodesAtLevel;
import static java.lang.Math.min;

public class Individual {
    Node head = new Node(null, null, null);
    Node last_child = head;
    int MAX_RANDOM_VALUE = 100;
    int MIN_RANDOM_VALUE = 0;
    double MUTATION_PER_NODE = 0.05;
    static Random random = new Random();
    public Individual(Node root){
        head = root;
    }
    public Individual(){}
    public Node generateIndividual(int maxDepth){
        PossibleExpressions[] enumValues = PossibleExpressions.values();
        PossibleExpressions randomExpression = enumValues[random.nextInt(enumValues.length)];

        Node newNode = null;
        if (maxDepth == 1) {
            newNode = new Node(PossibleExpressions.VARIABLE, null, last_child,
                    random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE));
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
        }
        return newNode;
    }
    public Individual crossover(Individual parent2){
        Node offspring = copyTree(head);
        Node parent2Copy = copyTree(parent2.head);
        int h1 = offspring.height();
        int h2 = parent2Copy.height();

        System.out.println("\nParent1 height: " + h1);
        System.out.println("Parent2 height: " + h2);

        int crossoverHeight = random.nextInt(1, min(h1, h2));
        System.out.println("Crossover height: " + crossoverHeight);

        Node[] parent1COPoints = getNodesAtLevel(offspring, crossoverHeight).toArray(new Node[0]);
        Node[] parent2COPoints = getNodesAtLevel(parent2Copy, crossoverHeight).toArray(new Node[0]);

        Node crossoverPoint1 = parent1COPoints[random.nextInt(0, parent1COPoints.length)];
        Node crossoverPoint2 = parent2COPoints[random.nextInt(0, parent2COPoints.length)];

        crossoverPoint2.parent_ = crossoverPoint1.parent_;
        crossoverPoint1.parent_.children_[0] = crossoverPoint2;

        return new Individual(offspring);
    }

    public void mutate(Node root){
        if (root.children_ == null){
            return;
        }
        for (Node child : root.children_){
            if (random.nextInt(1, 101) <= (MUTATION_PER_NODE * 100)){
                if (child.expression_ != PossibleExpressions.VARIABLE) {
                    PossibleExpressions[] enumValues = PossibleExpressions.values();
                    PossibleExpressions randomExpression = enumValues[random.nextInt(enumValues.length)];
                    switch (randomExpression) {
                        case MUL -> child.expression_ = PossibleExpressions.MUL;
                        case DIV -> child.expression_ = PossibleExpressions.DIV;
                        case ADD -> child.expression_ = PossibleExpressions.ADD;
                        case SUB -> child.expression_ = PossibleExpressions.SUB;
//                        case VARIABLE -> {
//                            child.value_ = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
//                            child.children_ = null;
//                        }
                    }
                }
                else{
                    child.value_ = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
                }
            }
            mutate(child);
        }
    }

    public void selfRepresent(Node node){
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

    public void save(String filename){
        //TODO: Serialize to JSON file
    }
}
