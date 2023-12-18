package EvolutionUtils;

import java.util.*;

import static java.lang.Math.min;

import GrammarNodes.*;
import Interpreter.Extensions.BoolStatement;
import Interpreter.InterpreterInterface;


public class Individual {
    Node programHead;
    int MAX_RANDOM_VALUE = 100;
    int MIN_RANDOM_VALUE = 0;
    double MUTATION_PER_NODE = 0.05;
    int individualDepth;
    static Random random = new Random();
    public Individual(Node root){
        programHead = root;
    }
    public Individual() {}

    public void generate(int depth){
        individualDepth = depth;
        this.programHead = Program.generateProgram(depth);
    }
    public String plot() {
        return this.programHead.plot();
    }
    public String eval(int maxOperations){
        InterpreterInterface interpreter = new InterpreterInterface(individualDepth * 10);

        return interpreter.evaluateProgram(this.plot(), "inputFile.txt", "output1.txt");
    }
    // TODO: Naprawic crossover, mutate, serializacje i deserializacje
    // TODO: Dodac możliwość wysyłania prgramu prosto do interpretera i pobieranie z interpretera wyniku działania programu

    public Individual crossover(Individual parent2){
        ArrayList<String> commands = new ArrayList<>(List.of("Loop", "IfStatement", "Expression", "VariableAssign", "Output"));
        ArrayList<String> expression = new ArrayList<>(List.of("Input", "Variable"));


        int h1 = height(this.programHead);
        int h2 = height(parent2.programHead);
        int counter = 0;
        Node node1 = this.programHead;
        Node node2 = parent2.programHead;
        int limit  = 1000000000;

        while( counter < limit)
        {
            for (int i=0; i<random.nextInt(0, h1) + 1; i++)
            {
                node1 = getRandomNode(node1);
            }
            for (int i=0; i<random.nextInt(0, h2) + 1; i++)
            {
                node2 = getRandomNode(node2);
            }
            int heightNode1 = height(node1);
            int heightNode2 = height(node2);

            if (    (   (  commands.contains(node1.getSuperClass()) && commands.contains(node2.getSuperClass()) ) ||
                        (  expression.contains(node1.getSuperClass()) && expression.contains(node2.getSuperClass()) ) ||
                        (  node1.getSuperClass().equals("BoolStatement") && node2.getSuperClass().equals("BoolStatement") ) ||
                        (  node1.getSuperClass().equals("ComparisonOperator") && node2.getSuperClass().equals("ComparisonOperator") ) ||
                        (  node1.getSuperClass().equals("LogicalOperator") && node2.getSuperClass().equals("LogicalOperator") ) ||
                        (  node1.getSuperClass().equals("ProgramNode") && node2.getSuperClass().equals("ProgramNode") )
                    ) && heightNode1 != 0 && heightNode2 != 0
                    && h1 != heightNode1 && h2 != heightNode2)
            {
                System.out.println("\nParent1 height: " + heightNode1);
                System.out.println("Parent2 height: " + heightNode2);
                System.out.println("\nParent1 node: " + node1.getSuperClass());
                System.out.println("Parent2 node: " + node2.getSuperClass());
                node1 = node2;
                node1.child = node2.child;
                node1.children = node2.children;
                node1.childrenBlock1 = node2.childrenBlock1;
                node1.childrenBlock2 = node2.childrenBlock2;
                break;
            }
            counter += 1;
            if ( counter % Math.max(h1,h2) == 0)
            {
                node1 = this.programHead;
                node2 = parent2.programHead;
            }
            if (counter == limit - 1)
            {
                System.out.println("PROGRAM NOT CROSSED");
            }
            System.out.println("\nParent1 height: " + heightNode1);
            System.out.println("Parent2 height: " + heightNode2);
            System.out.println("\nParent1 node: " + node1.getSuperClass());
            System.out.println("Parent2 node: " + node2.getSuperClass());
        }
        return this;
    }

    public Node getRandomNode(Node myNode) {
        if ( !myNode.children.isEmpty() ) {
            if(random.nextInt(0, 2) != 0)
            {
                int newNodeId = random.nextInt(0, myNode.children.size());
                return myNode.children.get(newNodeId);
            }

        } else if ( !myNode.childrenBlock1.isEmpty() || !myNode.childrenBlock2.isEmpty()) {
            if(random.nextInt(0, 2) != 0 && !myNode.childrenBlock1.isEmpty())
            {
                int newNodeId = random.nextInt(0, myNode.childrenBlock1.size());
                return myNode.childrenBlock1.get(newNodeId);
            }
            if(random.nextInt(0, 2) != 0 && !myNode.childrenBlock2.isEmpty()) {
                int newNodeId = random.nextInt(0, myNode.childrenBlock2.size());
                return myNode.childrenBlock2.get(newNodeId);
            }
        } else if(myNode.child != null)
        {
            if(random.nextInt(0, 2) != 0)
                return myNode.child;
        }
        return myNode;
    }

//    public void mutate(Node root){
//        if (root.children_ == null){
//            return;
//        }
//        for (Node child : root.children_){
//            if (random.nextInt(1, 101) <= (MUTATION_PER_NODE * 100)){
//                if (child.expression_ != Expression.VARIABLE) {
//                    Expression[] enumValues = Expression.values();
//                    Expression randomExpression = enumValues[random.nextInt(enumValues.length)];
//                    switch (randomExpression) {
//                        case MUL -> child.expression_ = Expression.MUL;
//                        case DIV -> child.expression_ = Expression.DIV;
//                        case ADD -> child.expression_ = Expression.ADD;
//                        case SUB -> child.expression_ = Expression.SUB;
////                        case VARIABLE -> {
////                            child.value_ = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
////                            child.children_ = null;
////                        }
//                    }
//                }
//                else{
//                    child.value_ = random.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
//                }
//            }
//            mutate(child);
//        }
//    }

//    public void print(Node node){
//        if (node.parent_ == null) {
//            node = node.children_[0];
//        }
//
//        if (node.children_ == null) {
//            System.out.print(node.value_);
//            return;
//        }
//
//        if (node.expression_ == null) {
//            selfRepresent(node.children_[0]);
//            System.out.print(node.value_);
//        }
//        else {
//            System.out.print("(");
//            selfRepresent(node.children_[0]);
//            switch (node.expression_){
//                case MUL -> System.out.print("*");
//                case DIV -> System.out.print("/");
//                case ADD -> System.out.print("+");
//                case SUB -> System.out.print("-");
//            }
//            selfRepresent(node.children_[1]);
//            System.out.print(")");
//        }
//    }
//
//    public void save(String fileName) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        ObjectNode rootNode = createJsonNode(head);
//
//        objectMapper.writeValue(new File(fileName), rootNode);
//    }
//
//    public Node load(String fileName) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode rootNode = objectMapper.readTree(new File(fileName));
//
//        return createTreeNode(rootNode);
//    }
//
//    private ObjectNode createJsonNode(Node node){
//        if (node == null)
//            return null;
//        ObjectMapper objectMapper = new ObjectMapper();
//        ObjectNode nodeObject = objectMapper.createObjectNode();
//        if (node.expression_ == null)
//            nodeObject.put("expression_label", "null");
//        else
//            nodeObject.put("expression_label", node.expression_.label);
//        nodeObject.put("value", node.value_);
////        if (node.parent_ == null)
////            nodeObject.put("parent", "null");
////        else
////            nodeObject.put("parent", node.parent_);
//
//        ArrayNode childrenArray = objectMapper.createArrayNode();
//        if (node.children_ != null) {
//            for (Node child : node.children_) {
//                ObjectNode childNode = createJsonNode(child);
//                childrenArray.add(childNode);
//            }
//        }
//
//        nodeObject.set("children", childrenArray);
//
//        return nodeObject;
//    }
//
//    private Node createTreeNode(JsonNode jsonNode) {
//        if (jsonNode == null || jsonNode.isNull())
//            return null;
//        Node treeNode;
//        Expression[] enumValues = Expression.values();
//        if (Objects.equals(jsonNode.get("expression_label").asText(), "null"))
//            treeNode = new Node(null, null, null, jsonNode.get("value").asInt());
//        else {
//            Expression expression = enumValues[jsonNode.get("expression_label").asInt() - 1];
//            treeNode = new Node(expression, null, null, jsonNode.get("value").asInt());
//        }
//
//
//        JsonNode childrenNode = jsonNode.get("children");
//        if (childrenNode != null && childrenNode.isArray()) {
//            Node[] children = new Node[childrenNode.size()];
//            int index = 0;
//            for (JsonNode child : childrenNode) {
//                Node childTreeNode = createTreeNode(child);
//                children[index++] = childTreeNode;
////                if (childTreeNode != null) {
////                    treeNode.addChild(childTreeNode);
////                }
//                treeNode.children_ = children;
//                System.out.println(Arrays.toString(children));
//            }
//        }
//
//        return treeNode;
//    }



//
//    public ProgramNode.Node copy() {
//        ProgramNode.Node copyNode = new ProgramNode.Node(this.expression_, null, null, this.value_);
//
//        if (this.children_ != null) {
//            copyNode.children_ = new ProgramNode.Node[this.children_.length];
//            for (int i = 0; i < this.children_.length; i++) {
//                ProgramNode.Node childCopy = this.children_[i].copy();
//                childCopy.parent_ = copyNode;
//                copyNode.children_[i] = childCopy;
//            }
//        }
//
//        return copyNode;
//    }
//
//    public static ProgramNode.Node copyTree(ProgramNode.Node root) {
//        if (root == null) {
//            return null;
//        }
//
//        ProgramNode.Node rootCopy = root.copy();
//        rootCopy.parent_ = null;
//
//        return rootCopy;
//    }

    public int height(Node myNode) {
        int maxHeight1 = 0;
        int maxHeight2 = 0;
        if ( myNode.child != null )
        {
            return 1;
        } else if ( !myNode.children.isEmpty() ) {
            for( Node child : myNode.children)
            {
                int childHeight = this.height(child);
                maxHeight1 = Math.max(maxHeight1, childHeight);
            }
            return maxHeight1 + 1;
        } else if ( !myNode.childrenBlock1.isEmpty() || !myNode.childrenBlock2.isEmpty()) {
            for( Node child : myNode.childrenBlock1)
            {
                int childHeight = this.height(child);
                maxHeight1 = Math.max(maxHeight1, childHeight);
            }

            for( Node child : myNode.childrenBlock2)
            {
                int childHeight = this.height(child);
                maxHeight2 = Math.max(maxHeight2, childHeight);
            }
            return Math.max(maxHeight1, maxHeight2) + 1;
        } else {
            return 0;
        }
    }
//
//    public static ArrayList<ProgramNode.Node> getNodesAtLevel(ProgramNode.Node root, int level) {
//        ArrayList<ProgramNode.Node> nodesAtLevel = new ArrayList<>();
//        Queue<ProgramNode.Node> queue = new LinkedList<>();
//        int currentLevel = 0;
//
//        if (root != null) {
//            queue.add(root);
//
//            while (!queue.isEmpty() && currentLevel < level) {
//                int levelSize = queue.size();
//
//                for (int i = 0; i < levelSize; i++) {
//                    ProgramNode.Node node = queue.poll();
//
//                    if (node.children_ != null) {
//                        Collections.addAll(queue, node.children_);
//                    }
//                }
//
//                currentLevel++;
//            }
//
//            while (!queue.isEmpty() && currentLevel == level) {
//                nodesAtLevel.add(queue.poll());
//            }
//        }
//
//        return nodesAtLevel;
//    }
}
