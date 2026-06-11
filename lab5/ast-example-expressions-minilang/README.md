# ANTLR4 Java AST Example

This project demonstrates how to use ANTLR4 to parse arithmetic expressions and build a semantic Abstract Syntax Tree (AST) in Java using the Visitor pattern.

## Prerequisites
- Java (JDK 8+)
- ANTLR4 tool and runtime (download from https://www.antlr.org/)

## Quick Start

1. **Generate parser and visitor:**

    make antlr

2. **Compile Java sources:**

    make build

3. **Run the example:**

    make run INPUT="1+2*3\n"

## Makefile Targets
- `antlr`: Generates parser/lexer/visitor from `Expr.g4`.
- `build`: Compiles all Java sources in `src/`.
- `run`: Runs the main class with optional `INPUT` argument.
- `clean`: Removes generated files and class files.

## Example Input
```
1+2*3
```

## Project Structure
- `src/Expr.g4` — ANTLR grammar
- `src/ast/` — AST node classes
- `src/ASTBuilderVisitor.java` — Visitor to build AST
- `src/Main.java` — Main class to parse and print AST

## Notes
- You may need to adjust the `ANTLR_JAR` variable in the Makefile to point to your local ANTLR jar file.
- The AST is printed in a simple indented format for demonstration.

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
