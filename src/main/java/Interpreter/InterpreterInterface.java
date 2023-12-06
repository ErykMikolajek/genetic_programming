package Interpreter;

import Interpreter.Extensions.AntlrProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class InterpreterInterface {
    public static void main(String[] args) {
        //TODO: zliczanie instrukcji, po zbyt dużej liczbie instrukcji program przestaje się wykonywać
        //TODO: zwiekszanie countera instrukcji wraz z wzrostem fitnessu/zlozonosci programu
        if (args.length != 1)
            System.err.println("Usage: no filename with program");
        else {
            String fileName = args[0];
            MiniGPLangParser parser = getParser(fileName);
            try
            {
                ParseTree antlrAST = parser.prog();

                // Create a listener for errors and reinitialization checking
//                AntlrListener listener = new AntlrListener();

//                ParseTreeWalker firstWalker = new ParseTreeWalker();
//                firstWalker.walk(listener, antlrAST);

                // Create a visitor for converting the parse tree into lines expressions objects
                AntlrProgram programVisitor = new AntlrProgram();
                programVisitor.visit(antlrAST);

            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }


    private static MiniGPLangParser getParser(String fileName)
    {
        MiniGPLangParser parser;
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            MiniGPLangLexer lexer = new MiniGPLangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new MiniGPLangParser(tokens);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parser;
    }
}
