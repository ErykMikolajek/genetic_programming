package antlr;

import GrammarNodes.*;

import java.util.ArrayList;

import static antlr.Individual.random;

public class Program {

    public static int variableId = 0;
    public static int MAX_VARIABLE_VALUE = 1000;

    public static Node generateProgram(int depth){
        ArrayList<Node> children = new ArrayList<>();
        while (depth > 0){
            children.add(generateCommand(depth--));
        }
        return new ProgramNode(children);
    }

    private static Node generateCommand(int depth){
        if (depth == 0) return null;

        Commands[] commandsValues = Commands.values();
        Commands randomCommand = commandsValues[random.nextInt(commandsValues.length)];

        switch (randomCommand){
            case LOOP -> {
                return generateLoop(depth - 1);
            }
            case IF_STATEMENT -> {
                return generateIfStatement(depth - 1);
            }
            case EXPRESSION -> {
                return generateExpression(depth - 1);
            }
            case ASSIGN -> {
                return generateAssign(depth - 1);
            }
            case OUTPUT -> {
                return generateOutput(depth - 1);
            }
            default -> {
                return null;
            }
        }
    }
    private static Node generateLoop(int depth){
        if (depth == 0) return null;

        Loop.PossibleLoops[] loopsValues = Loop.PossibleLoops.values();
        Loop.PossibleLoops randomLoop = loopsValues[random.nextInt(loopsValues.length)];
        Loop returnNode = null;
        switch (randomLoop){
            case FOR -> {
                Node expression = Program.generateExpression(depth - 1);
                ArrayList<Node> block = Program.generateBlock(depth - 1);

                assert block != null;
                returnNode = new Loop(Loop.PossibleLoops.FOR, expression, block);
            }
            case WHILE -> {
                Node boolStatement = Program.generateBoolStatement(depth - 1);
                ArrayList<Node> block = Program.generateBlock(depth - 1);

                assert block != null;
                returnNode = new Loop(Loop.PossibleLoops.WHILE, boolStatement, block);
            }
        }
        return returnNode;
    }

    private static Node generateIfStatement(int depth){
        if (depth == 0) return null;

        boolean elseCondition = random.nextInt(2) > 0;
        IfStatement returnNode;
        Node boolStatement = Program.generateBoolStatement(depth - 1);
        ArrayList<Node> block1 = Program.generateBlock(depth - 1);
        ArrayList<Node> block2;
        if (elseCondition) {
            block2 = Program.generateBlock(depth - 1);
            assert block1 != null;
            assert block2 != null;
            returnNode = new IfStatement(true, boolStatement, block1, block2);
        }
        else {
            assert block1 != null;
            returnNode = new IfStatement(false, boolStatement, block1);
        }

        return returnNode;
    }

    private static Node generateExpression(int depth) {
        if (depth == 0) return null;
        Expression.PossibleExpressions[] enumValues = Expression.PossibleExpressions.values();
        Expression.PossibleExpressions randomExpression = enumValues[random.nextInt(enumValues.length)];

        Node returnNode = null;
        if (depth == 1) {
            returnNode = Program.generateVariable(1);
        }
        else {
            Node childExpression1 = Program.generateExpression(depth - 1);
            Node childExpression2 = Program.generateExpression(depth - 1);
            switch (randomExpression) {
                case MUL -> returnNode = new Expression(Expression.PossibleExpressions.MUL,
                        childExpression1, childExpression2);
                case DIV -> returnNode = new Expression(Expression.PossibleExpressions.DIV,
                        childExpression1, childExpression2);
                case ADD -> returnNode = new Expression(Expression.PossibleExpressions.ADD,
                        childExpression1, childExpression2);
                case SUB -> returnNode = new Expression(Expression.PossibleExpressions.SUB,
                        childExpression1, childExpression2);
                case VARIABLE -> returnNode = Program.generateVariable(depth - 1);
            }
        }

        return returnNode;
    }

    private static Node generateAssign(int depth){
        if (depth == 0) return null;

        String variableName = "var" + variableId;
        variableId++;

        VariableAssignment returnNode;
        Node expression = Program.generateExpression(depth - 1);
        returnNode = new VariableAssignment(expression, variableName);
        return returnNode;
    }

    private static Node generateOutput(int depth){
        if (depth == 0) return null;

        Output returnNode;
        Node expression = Program.generateExpression(depth - 1);
        returnNode = new Output(expression);
        return returnNode;
    }

    private static Node generateVariable(int depth) {
        if (depth == 0) return null;

        Variable.PossibleVariables[] variablesValues = Variable.PossibleVariables.values();
        Variable.PossibleVariables randomVariable = variablesValues[random.nextInt(variablesValues.length)];
        Variable returnNode = null;
        switch (randomVariable){
            case VARIABLE_NAME -> {
                String randomVariableName;
                if (variableId > 0) randomVariableName = "var" + random.nextInt(variableId);
                else randomVariableName = "var0";
                returnNode = new Variable(Variable.PossibleVariables.VARIABLE_NAME, randomVariableName);
            }
            case NUMBER -> {
                int randomVariableValue = random.nextInt(MAX_VARIABLE_VALUE);
                returnNode = new Variable(Variable.PossibleVariables.VARIABLE_NAME, randomVariableValue);
            }
        }
        return returnNode;
    }

    private static ArrayList<Node> generateBlock(int depth) {
        if (depth == 0) return null;
        ArrayList<Node> returnNodes = new ArrayList<>();

        int numberOfCommands = random.nextInt(depth);
        for (int k = 0; k < numberOfCommands; k++){
            returnNodes.add(generateCommand(depth - 1));
        }
        return returnNodes;
    }

    private static Node generateBoolStatement(int depth){
        if (depth == 0) return null;

        BoolStatements[] boolStatements = BoolStatements.values();
        BoolStatements randomStatement = boolStatements[random.nextInt(boolStatements.length)];

        Node returnNode = null;
        switch (randomStatement){
            case EXPRESSION_OPERATOR_EXPRESSION -> {
                Node childExpression1 = Program.generateExpression(depth - 1);
                Node childExpression2 = Program.generateExpression(depth - 1);

                ComparisonOperator.PossibleComparisonOperators[] comparisonOperators =
                        ComparisonOperator.PossibleComparisonOperators.values();
                ComparisonOperator.PossibleComparisonOperators randomOperator =
                        comparisonOperators[random.nextInt(boolStatements.length)];

                returnNode = new ComparisonOperator(randomOperator, childExpression1, childExpression2);
            }
            case EXPRESSION -> returnNode = Program.generateExpression(depth - 1);
            case BOOL_OPERATOR_BOOL -> {
                Node boolStatement1 = Program.generateBoolStatement(depth - 1);
                Node boolStatement2 = Program.generateBoolStatement(depth - 1);

                LogicalOperator.PossibleLogicalOperators[] logicalOperators =
                        LogicalOperator.PossibleLogicalOperators.values();
                LogicalOperator.PossibleLogicalOperators randomOperator =
                        logicalOperators[random.nextInt(boolStatements.length)];

                returnNode = new LogicalOperator(randomOperator, boolStatement1, boolStatement2);
            }
        }
        return returnNode;
    }
}
