package antlr;

public enum ExpressionsEnum {
    MUL(1),
    DIV(2),
    ADD(3),
    SUB(4),
    VARIABLE(5);

    public final int label;
    ExpressionsEnum(int label) {
        this.label = label;
    }
}
