# Path to your ANTLR jar (update if needed)
ANTLR_JAR?=/Users/jpalmeida/Documents/ufes/ensino/2025-01-compiladores/workspace/tools/antlr-4.13.2-complete.jar

SRC=src
GEN=$(SRC)/parser
BIN=bin
CLASSPATH=.:$(ANTLR_JAR):$(SRC):$(BIN)

JAVA_FILES=$(shell find $(SRC) -name '*.java')
ANTLR_FILES=$(GEN)/ExprLexer.java $(GEN)/ExprParser.java $(GEN)/ExprBaseVisitor.java $(GEN)/ExprVisitor.java

.PHONY: all antlr build run clean

all: build

antlr: Expr.g4
	java -jar $(ANTLR_JAR) -visitor -no-listener -o $(GEN) $<

$(ANTLR_FILES): antlr

build: $(JAVA_FILES) $(ANTLR_FILES)
	mkdir -p $(BIN)
	javac -cp $(CLASSPATH) -d $(BIN) $(JAVA_FILES)

run: build
	@if [ -z "$(INPUT)" ]; then \
		echo "No input, using default "; \
		java -cp $(CLASSPATH) Main ; \
		exit 0; \
	else \
		java -cp $(CLASSPATH) Main "$(INPUT)" ; \
	fi

run-tree: build
	java -cp $(CLASSPATH) org.antlr.v4.gui.TestRig parser.Expr expr -tree -gui

clean:
	rm -rf $(BIN)/*
	rm -f $(GEN)/Expr*.java
	rm -rf $(SRC)/.antlr
