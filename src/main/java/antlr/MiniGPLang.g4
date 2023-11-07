grammar MiniGPLang;

prog
    :(line EOL*)+ line? EOF    # Program
    ;

line
    : EOL* command+ EOL*
    ;

command
    : loop                      # CommandLoop
    | ifStatement               # CommandIfStatement
    | expression                # CommandExpression
    | assignVariable            # CommandAssign
    ;

loop
    : 'for' '(' expression ')' block
    ;

block
    : '{' EOL? command+ '}'
    ;

ifStatement
    : 'if' '(' boolStatement ')' EOL* block EOL* ('elif' '(' boolStatement ')' EOL* block)* EOL* ('else' EOL* block)?
    ;

boolStatement
    : expression comparisonOperator expression      # VariableOperatorVariable
    | expression                                    # VariableBool
    | boolStatement logicalOperator boolStatement   # BoolOperatorBool
    | '(' boolStatement ')'                         # ParenthesisBool
    | '~' boolStatement                             # NotOperator
    ;

assignVariable
    : TYPE VARNAME '=' expression EOL
    ;

expression
    : '(' expression ')'                    # ParenthesisExpression
    | expression ('*' | '/') expression     # MultiplicationDivision
    | expression ('+' | '-') expression     # AdditionSubstraction
    | variable                              # VariableExpression
    ;

variable
    : VARNAME
    | NUMBER
    ;

logicalOperator
    : '&&'          # LogicalAnd
    | '||'          # LogicalOr
    ;

comparisonOperator
    : '<'          # ComparisonLess
    | '>'          # ComparisonGreater
    | '<='         # ComparisonLessEqual
    | '>='         # ComparisonGreaterEqual
    | '=='          # ComparisonEqual
    | '!='         # ComparisonNotEqual
    ;

VARNAME
    : [A-Z_]+
    ;

TYPE
    : 'int'
    | 'double'
    | 'bool'
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