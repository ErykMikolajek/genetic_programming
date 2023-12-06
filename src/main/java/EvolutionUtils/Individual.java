package EvolutionUtils;

import java.util.Random;

import static java.lang.Math.min;

import GrammarNodes.Node;


public class Individual {
    Node programHead;
    int MAX_RANDOM_VALUE = 100;
    int MIN_RANDOM_VALUE = 0;
    double MUTATION_PER_NODE = 0.05;
    static Random random = new Random();
    public Individual(Node root){
        programHead = root;
    }
    public Individual(int depth){
        this.programHead = Program.generateProgram(depth);
    }
    // TODO: Naprawic crossover, mutate, serializacje i deserializacje
    // TODO: Dodac możliwość wysyłania prgramu prosto do interpretera i pobieranie z interpretera wyniku działania programu

//    public Individual crossover(Individual parent2){
//        Node offspring = copyTree(head);
//        Node parent2Copy = copyTree(parent2.head);
//        int h1 = offspring.height();
//        int h2 = parent2Copy.height();
//
//        System.out.println("\nParent1 height: " + h1);
//        System.out.println("Parent2 height: " + h2);
//
//        int crossoverHeight = random.nextInt(1, min(h1, h2));
//        System.out.println("Crossover height: " + crossoverHeight);
//
//        Node[] parent1COPoints = getNodesAtLevel(offspring, crossoverHeight).toArray(new Node[0]);
//        Node[] parent2COPoints = getNodesAtLevel(parent2Copy, crossoverHeight).toArray(new Node[0]);
//
//        Node crossoverPoint1 = parent1COPoints[random.nextInt(0, parent1COPoints.length)];
//        Node crossoverPoint2 = parent2COPoints[random.nextInt(0, parent2COPoints.length)];
//
//        crossoverPoint2.parent_ = crossoverPoint1.parent_;
//        crossoverPoint1.parent_.children_[0] = crossoverPoint2;
//
//        return new Individual(offspring);
//    }

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
    public String plot() {return this.programHead.plot();}

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
}
