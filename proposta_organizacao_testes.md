# Organização de Diretórios de Testes

Para um trabalho de Compiladores (que normalmente envolve Lexer, Parser, Análise Semântica, etc.), a organização dos testes fica muito mais limpa e escalável se você separar as **entradas** por fases ou por comportamento esperado (arquivos que devem ser aceitos vs. rejeitados), e as **saídas** por etapa de compilação.

Aqui está uma recomendação de como estruturar seu diretório `trabCC/testes/`:

```text
trabCC/
└── testes/
    ├── testador.sh           # Seu script que automatiza os testes
    └── io/                   # Diretório raiz para arquivos de I/O
        ├── in/               # Todas as ENTRADAS (casos de teste)
        │   ├── lexer/        # Arquivos criados especificamente para testar tokens (ex: strings mal formadas)
        │   ├── parser/       # Arquivos focados em testar regras gramaticais (sintaxe)
        │   ├── validos/      # Códigos completos em C que DEVEM passar sem erros
        │   └── invalidos/    # Códigos completos que DEVEM gerar erros (sintaxe ou léxico)
        │
        ├── expected/         # GABARITOS (Saídas Esperadas)
        │   ├── lexer/        # Os arquivos .out com as listas de tokens corretas
        │   └── parser/       # Os arquivos .tree com as ASTs corretas esperadas
        │
        └── generated/        # SAÍDAS GERADAS pelo script testador.sh (Devem estar no .gitignore)
            ├── lexer/        # Os tokens gerados na última execução
            └── parser/       # As árvores sintáticas geradas na última execução
```

## Por que essa estrutura é boa?

1. **Separação de Contexto**: Muitas vezes um teste foi feito apenas para estressar uma expressão regular no Lexer e não faz sentido ser lido pelo Parser (já que não é um programa C completo). A pasta `in/lexer/` abriga esses casos.
2. **Organização dos Gabaritos**: `expected/lexer/` guarda a expectativa só do Lexer, não se misturando com a estrutura sintática. E ao invés do nome genérico `out`, usamos `expected` que deixa muito clara a sua intenção (Gabarito).
3. **Limpeza do Git**: Fica muito fácil colocar `testes/io/generated/` no seu `.gitignore`, garantindo que ninguém mande lixo de execução para o repositório por engano.

---

## Como adaptar o `testador.sh` para suportar isso?

Se você quiser adotar a estrutura acima, você precisaria fazer alguns ajustes rápidos nas variáveis do arquivo `testador.sh`.

No topo do arquivo, você alteraria os caminhos de I/O:
```bash
DATA=$PROJECT_ROOT/io

# Entradas
IN_LEXER=$DATA/in/lexer
IN_PARSER=$DATA/in/parser

# Gabaritos Esperados
EXPECTED_LEXER=$DATA/expected/lexer
EXPECTED_PARSER=$DATA/expected/parser

# Saídas Geradas dinamicamente
OUT_GENERATED_LEXER=$DATA/generated/lexer
OUT_GENERATED_PARSER=$DATA/generated/parser
```

E no momento de realizar os loops dos testes, usaria essas variáveis separadas. Por exemplo, no `testar_lexer`:

```bash
mkdir -p $OUT_GENERATED_LEXER

for infile in $(ls $IN_LEXER/*.c); do
    base=$(basename $infile)
    generated_file=$OUT_GENERATED_LEXER/${base/.c/.out}
    expected_file=$EXPECTED_LEXER/${base/.c/.out}
    
    # ... código do TestRig (grun) ...
done
```

Dessa forma o seu script só testa o léxico nos arquivos da pasta do léxico, o que agiliza muito o desenvolvimento.
