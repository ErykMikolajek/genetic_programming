package EvolutionUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

import static java.lang.Math.min;

import GrammarNodes.*;
import Interpreter.InterpreterInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Individual {
    Node programHead;
    int MAX_RANDOM_VALUE = 100;
//    public ArrayList<Integer> inputVector;
    int individualDepth;
    public boolean isFailed = false;
    public double fitness;
    static Random random = new Random();
    private ArrayList<String> commands = new ArrayList<String>(List.of("IfStatement", "Loop", "VariableAssignment", "Output"));
    private ArrayList<String> Variable = new ArrayList<String>(List.of("Variable", "Input"));
    private ArrayList<String> BoolStatement = new ArrayList<String>(List.of("BoolStatement"));
    private ArrayList<String> ComparisonOperator = new ArrayList<String>(List.of("ComparisonOperator"));
    private ArrayList<String> LogicalOperator = new ArrayList<String>(List.of("LogicalOperator"));
    private ArrayList<String> ProgramNode = new ArrayList<String>(List.of("ProgramNode"));
    private ArrayList<String> Expression = new ArrayList<String>(List.of("Expression"));

    public Individual(Node root){
        programHead = root;
    }
    public Individual() {}

    public void generate(int depth){
        individualDepth = depth;
        this.programHead = Program.generateProgram(depth, MAX_RANDOM_VALUE);
    }
    public String plot() {
        return this.programHead.plot();
    }
    public ArrayList<Integer> eval(int maxOperations, int[] inputVector){
        InterpreterInterface interpreter = new InterpreterInterface(maxOperations);
        ArrayList<Integer> returnArray = interpreter.evaluateProgram(this.plot(), inputVector);
        this.isFailed = interpreter.didProgramFail;
        return returnArray;
    }

    public Individual crossover(Individual parent2){
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

            if (!node1.children.isEmpty()) {
                int index = random.nextInt(node1.children.size());
                int depth1 = height(node1.children.get(index));
                int depth2 = height(node2);
                Node newNode = node2;
                if (depth1 == depth2 && depth1 != h1 && depth2 != h2 &&
                        (
                                (   commands.contains(node1.children.get(index).getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                        (   Variable.contains(node1.children.get(index).getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                        (   BoolStatement.contains(node1.children.get(index).getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                        (   ComparisonOperator.contains(node1.children.get(index).getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                        (   LogicalOperator.contains(node1.children.get(index).getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                        (   ProgramNode.contains(node1.children.get(index).getSuperClass()) && ProgramNode.contains(newNode.getSuperClass())  )||
                                        (   Expression.contains(node1.children.get(index).getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  ))
                {
                    node1.children.set(index, newNode);
                    break;
                }
            } else if (!node1.childrenBlock1.isEmpty()) {
                int index = random.nextInt(node1.childrenBlock1.size());
                int depth1 = height(node1.childrenBlock1.get(index));
                int depth2 = height(node2);
                Node newNode = node2;
                if (depth1 == depth2 && depth1 != h1 && depth2 != h2 &&
                        (
                                (   commands.contains(node1.childrenBlock1.get(index).getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                        (   Variable.contains(node1.childrenBlock1.get(index).getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                        (   BoolStatement.contains(node1.childrenBlock1.get(index).getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                        (   ComparisonOperator.contains(node1.childrenBlock1.get(index).getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                        (   LogicalOperator.contains(node1.childrenBlock1.get(index).getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                        (   ProgramNode.contains(node1.childrenBlock1.get(index).getSuperClass()) && ProgramNode.contains(newNode.getSuperClass()))||
                                        (   Expression.contains(node1.childrenBlock1.get(index).getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  ))
                {
                    node1.childrenBlock1.set(index, newNode);
                    break;
                }
            } else if (!node1.childrenBlock2.isEmpty()) {
                int index = random.nextInt(node1.childrenBlock2.size());
                int depth1 = height(node1.childrenBlock2.get(index));
                int depth2 = height(node2);
                Node newNode = node2;
                if (depth1 == depth2 && depth1 != h1 && depth2 != h2 &&
                        (
                                (   commands.contains(node1.childrenBlock2.get(index).getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                        (   Variable.contains(node1.childrenBlock2.get(index).getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                        (   BoolStatement.contains(node1.childrenBlock2.get(index).getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                        (   ComparisonOperator.contains(node1.childrenBlock2.get(index).getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                        (   LogicalOperator.contains(node1.childrenBlock2.get(index).getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                        (   ProgramNode.contains(node1.childrenBlock2.get(index).getSuperClass()) && ProgramNode.contains(newNode.getSuperClass()))||
                                        (   Expression.contains(node1.childrenBlock2.get(index).getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  ))
                {
                    node1.childrenBlock2.set(index, newNode);
                    break;
                }

            } else if (node1.child != null) {
                int depth1 = height(node1.child);
                int depth2 = height(node2);
                Node newNode = node2;
                if (depth1 == depth2 && depth1 != h1 && depth2 != h2 &&
                        (   (   commands.contains(node1.child.getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                        (   Variable.contains(node1.child.getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                        (   BoolStatement.contains(node1.child.getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                        (   ComparisonOperator.contains(node1.child.getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                        (   LogicalOperator.contains(node1.child.getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                        (   ProgramNode.contains(node1.child.getSuperClass()) && ProgramNode.contains(newNode.getSuperClass())  )||
                                        (   Expression.contains(node1.child.getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  ))
                {
                    node1.child = newNode;
                    break;
                }
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

    public void mutate(){
        while (true){
            Node node = this.getRandomNode(this.programHead);

// get random child
            if (!node.children.isEmpty())
            {
                int index = random.nextInt(node.children.size());
                int depth = height(node);
                Node newNode = Program.generateCommand(depth);

                if (newNode != null && (
                    (   commands.contains(node.children.get(index).getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                    (   Variable.contains(node.children.get(index).getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                    (   BoolStatement.contains(node.children.get(index).getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                    (   ComparisonOperator.contains(node.children.get(index).getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                    (   LogicalOperator.contains(node.children.get(index).getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                    (   ProgramNode.contains(node.children.get(index).getSuperClass()) && ProgramNode.contains(newNode.getSuperClass())  )  ||
                    (   Expression.contains(node.children.get(index).getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  )
                )
                {

//                    System.out.println(node.children.get(index).getSuperClass());
//                    System.out.println(depth);
                    node.children.set(index, newNode);
                    break;
                }

            } else if (!node.childrenBlock1.isEmpty()) {
                int index = random.nextInt(node.childrenBlock1.size());
                int depth = height(node);
                Node newNode = Program.generateCommand(depth);
                if (newNode != null && (
                        (   commands.contains(node.childrenBlock1.get(index).getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                (   Variable.contains(node.childrenBlock1.get(index).getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                (   BoolStatement.contains(node.childrenBlock1.get(index).getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                (   ComparisonOperator.contains(node.childrenBlock1.get(index).getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                (   LogicalOperator.contains(node.childrenBlock1.get(index).getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                (   ProgramNode.contains(node.childrenBlock1.get(index).getSuperClass()) && ProgramNode.contains(newNode.getSuperClass())  )||
                                (   Expression.contains(node.childrenBlock1.get(index).getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  )
                )
                {

//                    System.out.println(node.childrenBlock1.get(index).getSuperClass());
//                    System.out.println(depth);
                    node.childrenBlock1.set(index, newNode);
                    break;
                }

            } else if (!node.childrenBlock2.isEmpty()) {
                int index = random.nextInt(node.childrenBlock2.size());
                int depth = height(node);
                Node newNode = Program.generateCommand(depth);
                if (newNode != null && (
                        (   commands.contains(node.childrenBlock2.get(index).getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                (   Variable.contains(node.childrenBlock2.get(index).getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                (   BoolStatement.contains(node.childrenBlock2.get(index).getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                (   ComparisonOperator.contains(node.childrenBlock2.get(index).getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                (   LogicalOperator.contains(node.childrenBlock2.get(index).getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                (   ProgramNode.contains(node.childrenBlock2.get(index).getSuperClass()) && ProgramNode.contains(newNode.getSuperClass())  )||
                                (   Expression.contains(node.childrenBlock2.get(index).getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  )
                )
                {

//                    System.out.println(node.childrenBlock2.get(index).getSuperClass());
//                    System.out.println(depth);
                    node.childrenBlock2.set(index, newNode);
                    break;
                }

            } else if (node.child != null) {
                int depth = height(node);
                Node newNode = Program.generateCommand(depth);
                if (newNode != null && (
                        (   commands.contains(node.child.getSuperClass()) && commands.contains(newNode.getSuperClass())  ) ||
                                (   Variable.contains(node.child.getSuperClass()) && Variable.contains(newNode.getSuperClass())  ) ||
                                (   BoolStatement.contains(node.child.getSuperClass()) && BoolStatement.contains(newNode.getSuperClass())  ) ||
                                (   ComparisonOperator.contains(node.child.getSuperClass()) && ComparisonOperator.contains(newNode.getSuperClass())  ) ||
                                (   LogicalOperator.contains(node.child.getSuperClass()) && LogicalOperator.contains(newNode.getSuperClass())  ) ||
                                (   ProgramNode.contains(node.child.getSuperClass()) && ProgramNode.contains(newNode.getSuperClass())  )||
                                (   Expression.contains(node.child.getSuperClass()) && Expression.contains(newNode.getSuperClass())  )  )
                )
                {

//                    System.out.println(node.child.getSuperClass());
//                    System.out.println(depth);
                    node.child = newNode;
                    break;
                }
            }
        }
    }

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

    public void serialize(String filePath) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Node.class,
                            new IndividualDesSer()).setPrettyPrinting().create();
            Writer writer = new FileWriter(filePath);
            gson.toJson(this, writer);
            writer.flush(); //flush data to file   <---
            writer.close(); //close write          <---
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Individual deserialize(String filePath) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Node.class,
                            new IndividualDesSer()).setPrettyPrinting().create();

            return gson.fromJson(new FileReader(filePath), Individual.class);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Incorrect file!!!");
        }
        return null;
    }
}
