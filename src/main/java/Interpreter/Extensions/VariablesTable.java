package Interpreter.Extensions;

import java.util.HashMap;
import java.util.Map;

public class VariablesTable {
    public static Map<String, Integer> savedVariables = new HashMap<>();
    public static void addVariable(String varName, int value){
        savedVariables.put(varName, value);
    }
    public static int getVariableValue(String varName){
        if (savedVariables.get(varName) == null) throw new RuntimeException("Accessing variable before initialization");
        else return savedVariables.get(varName);
    }
}
