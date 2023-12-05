package Interpreter.Extensions;

import java.util.HashMap;
import java.util.Map;

public class VariablesTable {
    public static Map<String, Integer> savedVariables = new HashMap<>();
    public static void addVariable(String varName, int value){
        savedVariables.put(varName, value);
    }
    public static int getVariableValue(String varName){
        return savedVariables.get(varName) == null ? -999 : savedVariables.get(varName);
    }
}
