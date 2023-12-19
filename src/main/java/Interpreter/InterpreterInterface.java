package Interpreter;

import Interpreter.Extensions.AntlrProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileWriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.antlr.v4.runtime.CharStreams.fromString;

public class InterpreterInterface {

    private final int maxOperationCount;
    public boolean didProgramFail;
    public InterpreterInterface(int maxOperationCount){
        this.maxOperationCount = maxOperationCount;
        this.didProgramFail = false;
    }

    public ArrayList<Integer> evaluateProgram(String program, String inputFileName){
        MiniGPLangParser parser = getParser(program);
        ParseTree antlrAST = parser.prog();
        AntlrProgram programVisitor = new AntlrProgram(inputFileName, maxOperationCount);
        programVisitor.visit(antlrAST);
        this.didProgramFail = AntlrProgram.didProgramFail;

        return AntlrProgram.programOutput;
    }


    private static MiniGPLangParser getParser(String program)
    {
        MiniGPLangParser parser;
        CharStream stream = fromString(program);
        MiniGPLangLexer lexer = new MiniGPLangLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new MiniGPLangParser(tokens);
        return parser;
    }
}
