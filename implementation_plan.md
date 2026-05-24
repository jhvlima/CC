# Implementação da Análise Semântica e Tabelas no trabCC

Este plano descreve os passos para aplicar as análises detalhadas no `CC_Lab03_Java.pdf` ao compilador de C para WebAssembly (`trabCC`).

## Objetivo
Implementar a etapa de Análise Semântica utilizando o padrão Visitor do ANTLR para preencher e utilizar duas tabelas:
1. **Tabela de Símbolos**: armazena variáveis (nome, tipo e linha de declaração).
2. **Tabela de Strings (Literais)**: armazena literais de string encontrados no código.

O analisador deve verificar duas regras fundamentais:
- Uso de variáveis não declaradas.
- Redeclaração de variáveis no mesmo escopo.

---

## Passos para Implementação

### 1. Preparar a Gramática (Cparser.g)
Para facilitar a visitação dos nós pelo analisador semântico, precisamos adicionar "nomes" (`# labels`) a algumas alternativas de regras na gramática, principalmente onde há muita variação.
- **`primary`**: Adicionar rótulos para diferenciar quando é `IDENTIFIER` (uso de variável) e `STRING_LITERAL`.
- **`declaration` / `init_declarator`**: Garantir que as regras de declaração de variáveis sejam fáceis de visitar para extrair o tipo (`type_spec`) e o nome (`IDENTIFIER`).

### 2. Criação das Estruturas de Dados
Criar arquivos Java para representar as tabelas e os símbolos:
- `Symbol.java`: Classe para armazenar os dados de um símbolo (nome, tipo (ex: `int`, `char`, `bool`) e linha de declaração).
- `SymbolTable.java`: Classe contendo um `HashMap<String, Symbol>` para inserir, buscar e imprimir símbolos.
- `StringTable.java`: Classe contendo uma coleção (`HashSet` ou `ArrayList`) para guardar literais de string únicos.

### 3. Implementação do Visitor Semântico
Criar a classe `SemanticAnalyzer` (ou `SemanticVisitor`) que estende `CparserBaseVisitor<Void>`.
- **Visitar Declarações de Variáveis**:
  - Interceptar as declarações (ex: `visitDeclaration`).
  - Extrair o nome da variável e o seu tipo.
  - Se a variável já existir na `SymbolTable`, emitir erro:
    `SEMANTIC ERROR (XX): variable 'VV' already declared at line YY.`
  - Caso contrário, adicioná-la à `SymbolTable`.
- **Visitar Uso de Variáveis**:
  - Interceptar usos de variáveis (ex: identificadores dentro de expressões `visitPrimary`).
  - Consultar a `SymbolTable`.
  - Se a variável não existir, emitir erro:
    `SEMANTIC ERROR (XX): variable 'VV' was not declared.`
- **Visitar Strings**:
  - Interceptar nós de strings e adicioná-los à `StringTable`.

### 4. Criação da Classe Principal (App.java)
Criar uma classe `App` contendo o método `main`:
1. Instanciar o `Clexer` e `Cparser`.
2. Gerar a árvore sintática (`ParseTree tree = parser.begin();`).
3. Instanciar o `SemanticAnalyzer` (passando instâncias das tabelas).
4. Executar a análise com `visitor.visit(tree)`.
5. Imprimir as Tabelas de Símbolos e de Strings no terminal.

### 5. Atualização do testador.sh
Como as mudanças que fiz anteriormente foram revertidas, precisaremos novamente:
- Adicionar a flag `-visitor` na linha de compilação do ANTLR (`$ANTLR4 -no-listener -visitor ...`).
- Adicionar uma regra `run` ou `semantic` no testador para compilar a classe `App.java` e testá-la contra os arquivos do diretório `in/`.

---

## User Review Required

> [!IMPORTANT]  
> Você concorda com essa divisão de passos? 
> Se sim, posso começar alterando a gramática `Cparser.g` para adicionar os labels (`#`) que facilitarão a construção do `SemanticAnalyzer` e em seguida criar os arquivos Java para as Tabelas.
