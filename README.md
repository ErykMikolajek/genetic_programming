# Genetic Programming Project

## Introduction
This project implements a genetic programming approach to automatically generate programs in a simple custom programming language and then execute them using an own interpreter. The goal is to evolve programs that can solve basic programming and mathematical problems such as arithmetic operations, solving logic gates, finding the maximum and minimum values within a given set and more.  

The project utilizes ANTLR (ANother Tool for Language Recognition), to define and generate the lexer and parser for the custom programming language.  

## Project Structure

The project structure is organized as follows:
```
├── src  
│   ├── main: Source code for the genetic programming algorithm, interpreter, and ANTLR grammar files  
│   │   ├── EvolutionUtils: Classes defining individual program, population of programs  
│   │   ├── GrammarNodes: Nodes needed to generate random program tree  
│   │   ├── Interpreter: ANTLR grammar files  
│   │   │   ├── Extensions: Implementations of ANTLR visitor nodes  
│   ├── test: Benchmark for system effectiveness  
└── .gitignore  
```

## Custom Programming Language Syntax

The custom programming language syntax includes basic arithmetic operations loops, if statements, bool statements, output and input commands. The grammar for the language is defined using ANTLR in src/main/java/Interpreter/MiniGPLang.g4.

## Usage

In order to run this genetic algorithm on your own problem set you need to create an input file or input matrix. The structure of the input is given below:  
First line - three integers: n - number of test cases, d - input data vector length, t - target data vector length  
Lines 2..n - d input values followed by t target values 
Sample input file - representing addition:
```
5 2 1
9 8 17
3 2 5
9 9 18
1 2 3
1 1 2
```
The next step is to call the static `run` function of the GProject class and pass the number of iterations and input file as the parameters.
Program will then log each generation progress to the console and notify when the solution is found or if the problem is not solved.

## Contributing
Contributions to the project are welcome! If you have any ideas, bug fixes, or enhancements, please submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
