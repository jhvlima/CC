# baixa o ANTLR se não estiver baixado e configura alias importantes
PROJECT_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

ANTLR_JAR="$PROJECT_ROOT/tools/antlr-4.13.2-complete.jar"

if [ ! -f "$ANTLR_JAR" ]; then
    echo "Baixando ANTLR (antlr-4.13.2-complete.jar)..."
    mkdir -p "$PROJECT_ROOT/tools"
    curl -L -o "$ANTLR_JAR" https://www.antlr.org/download/antlr-4.13.2-complete.jar
fi

export CLASSPATH="$ANTLR_JAR:.:$CLASSPATH"
alias antlr4='java -jar "$ANTLR_JAR"'
alias grun='java -cp .:"$ANTLR_JAR" org.antlr.v4.gui.TestRig'
