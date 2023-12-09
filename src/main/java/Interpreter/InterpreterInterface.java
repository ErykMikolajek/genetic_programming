package Interpreter;

import Interpreter.Extensions.AntlrProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileWriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromString;

public class InterpreterInterface {

    private final int maxOperationCount;
    public InterpreterInterface(int maxOperationCount){
        this.maxOperationCount = maxOperationCount;
    }

    public String evaluateProgram(String program, String inputFileName, String outputFileName){
        MiniGPLangParser parser = getParser(program);
        ParseTree antlrAST = parser.prog();
        AntlrProgram programVisitor = new AntlrProgram(inputFileName, maxOperationCount);
        programVisitor.visit(antlrAST);

        try {
            FileWriter outputFile = new FileWriter("target/" + outputFileName);
            outputFile.write(AntlrProgram.programOutput);
            outputFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

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
