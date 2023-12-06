package Interpreter.Extensions;

public class AssignVariable extends Command{
    String name;
    public Variable var;

    public AssignVariable(String varName, Variable variable){
        this.name = varName;
        this.var = variable;
    }
}
