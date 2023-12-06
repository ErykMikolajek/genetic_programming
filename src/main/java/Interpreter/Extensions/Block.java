package Interpreter.Extensions;

import java.util.ArrayList;

public class Block {
    public ArrayList<Command> commands;
    public Block() {
        commands = new ArrayList<>();
    }
    public void addCommand(Command command){
        commands.add(command);
    }

}
