package Interpreter.Extensions;

import java.util.ArrayList;

public class Program {
    public ArrayList<Command> commands;

    public Program(){
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        commands.add(command);
    }
}
