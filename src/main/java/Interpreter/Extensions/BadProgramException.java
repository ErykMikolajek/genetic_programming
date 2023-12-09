package Interpreter.Extensions;

public class BadProgramException extends RuntimeException{
    public BadProgramException(String message) {
        super(message);
    }
}
