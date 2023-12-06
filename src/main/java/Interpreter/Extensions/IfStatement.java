package Interpreter.Extensions;

public class IfStatement extends Command{
    public Block ifBlock;
    public boolean ifBlockSatisfied;
    public Block elseBlock;

    public IfStatement(Block ifBlock, boolean satisfied){
        this.ifBlock = ifBlock;
        this.ifBlockSatisfied = satisfied;
        this.elseBlock = null;
    }
    public IfStatement(Block ifBlock, boolean satisfied, Block elseBlock){
        this.ifBlock = ifBlock;
        this.ifBlockSatisfied = satisfied;
        this.elseBlock = elseBlock;
    }
}
