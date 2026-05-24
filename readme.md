# Compiladores

Este repositório contém as atividades e os projetos práticos desenvolvidos nos laboratórios da disciplina de Compiladores.

## Ferramentas Utilizadas

* **Java:** Linguagem base utilizada para a implementação do código, gerenciamento de estruturas de dados e execução dos analisadores.
* **ANTLR (ANother Tool for Language Recognition):** Ferramenta principal utilizada para gerar os analisadores léxicos e sintáticos a partir das gramáticas definidas nos arquivos `.g`.
* **Make:** Utilizado para automatizar o processo de compilação, geração de código do ANTLR e execução dos testes através dos arquivos `Makefile`.
* **Shell Scripts (`.sh`):** Scripts auxiliares usados para automatizar tarefas do ambiente, como baixar dependências (`getTools.sh`) e rodar testes em lote (`gen_tests.sh`, `compare.sh`).

## Resumo dos Laboratórios

* **Lab 1: Análise Léxica (Lexer)**
  Focado na introdução ao ANTLR para a construção do analisador léxico. O laboratório aborda a definição de regras (expressões regulares) para o reconhecimento dos *tokens* de uma linguagem (ex: identificadores, números, palavras-chave) e o tratamento de caracteres que devem ser ignorados, como espaços em branco.

* **Lab 2: Análise Sintática (Parser)**
  Expande os conceitos do Lab 1 para a criação do analisador sintático. Neste laboratório, são definidas as regras gramaticais livres de contexto que ditam a estrutura da linguagem. A ferramenta valida se a sequência de *tokens* forma instruções e expressões coerentes, construindo a árvore de análise sintática (Parse Tree).

* **Lab 3: Análise Semântica e Padrão Visitor**
  Focado na validação do significado do código e abstração da árvore. O laboratório implementa o padrão *Visitor* para percorrer a árvore gerada pelo ANTLR, introduzindo Tabelas de Símbolos (`StrTable`, `VarTable`) para gerenciar escopo/variáveis e classes de tipagem (`Type.java`) para realizar a checagem de tipos e a avaliação semântica das expressões.
