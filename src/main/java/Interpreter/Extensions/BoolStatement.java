package Interpreter.Extensions;

public class BoolStatement {
    public boolean satisfied;
    public BoolStatement(Expression variable){
        if (variable instanceof Variable){
            satisfied = (((Variable) variable).value != 0);
        }
        else
            satisfied = false;
    }
    public BoolStatement(){
        satisfied = false;
    }
}
