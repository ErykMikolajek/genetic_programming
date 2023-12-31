grammar MiniGPLang;

prog
    : EOL* (command EOL*)+ EOF    # Program
    ;

command
    : loop                      # CommandLoop
    | ifStatement               # CommandIfStatement
    | expression                # CommandExpression
    | assignVariable            # CommandAssign
    | output                    # CommandOutput
    ;

loop
    : 'for' '(' expression ')' block        # ForLoop
    | 'while' '(' boolStatement ')' block   # WhileLoop
    ;

block
    : '{' EOL* (command EOL*)* EOL*'}'
    ;

ifStatement
    : 'if' '(' boolStatement ')' EOL* block EOL* ('else' EOL* block)?
    ;

boolStatement
    : expression comparisonOperator expression      # ExpressionOperatorExpression
    | expression                                    # ExpressionBool
    | boolStatement logicalOperator boolStatement   # BoolOperatorBool
//    | '(' boolStatement ')'                         # ParenthesisBool
//    | '~' boolStatement                             # NotOperator
    ;

assignVariable
    : VARNAME '=' expression EOL*
    ;

expression
//    : '(' expression ')'                    # ParenthesisExpression
    : expression ('*' | '/') expression     # MultiplicationDivision
    | expression ('+' | '-') expression     # AdditionSubstraction
    | variable                              # VariableExpression
    | input                                 # InputExpression
    ;

output
    : 'output' expression
    ;

input
    : 'input'
    ;

variable
    : VARNAME       # VariableGet
    | NUMBER        # NumberGet
    ;

logicalOperator
    : '&&'          # LogicalAnd
    | '||'          # LogicalOr
    ;

comparisonOperator
    : '<'          # ComparisonLess
    | '>'          # ComparisonGreater
    | '=='         # ComparisonEqual
    | '!='         # ComparisonNotEqual
    ;

VARNAME
    : 'var'[0-9]+
    ;

NUMBER
    : '0'|[1-9][0-9]*
    ;
    
EOL
    : '\r'? '\n'
    ;

WS
   : [ \t\r\n] -> skip
   ;