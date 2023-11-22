package antlr;

public enum BoolStatementsEnum {
    VAR_OP_VAR(1),
    DIV(2),
    ADD(3),
    SUB(4),
    VARIABLE(5);


    public final int label;
    BoolStatementsEnum(int label) {
        this.label = label;
    }
}
