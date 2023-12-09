package Interpreter.Extensions;

import Interpreter.MiniGPLangParser;

public class BoolStatement {
    public boolean satisfied;
    public BoolStatement(Command variable){
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
