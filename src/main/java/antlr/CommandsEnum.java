package antlr;

public enum CommandsEnum {
    LOOP(1),
    IF_STATEMENT(2),
    EXPRESSION(3),
    ASSIGN(4);


    public final int label;
    CommandsEnum(int label) {
        this.label = label;
    }
}
