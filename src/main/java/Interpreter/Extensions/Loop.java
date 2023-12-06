package Interpreter.Extensions;

public class Loop extends Command{
    public boolean isForLoop;
    public int range;
    public boolean satisfied;
    public Block commandsBlock;

    public Loop(int range, Block commandList)
    {
        this.range = range;
        this.commandsBlock = commandList;
        this.isForLoop = true;
    }
    public Loop(boolean is_satisfied, Block commandList){
        this.satisfied = is_satisfied;
        this.commandsBlock = commandList;
        this.isForLoop = false;
    }
}
