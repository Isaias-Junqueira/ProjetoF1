# Projeto F1

Sistema de linha de comando para cadastrar equipes de Fórmula 1 e seus
pilotos. O projeto foi desenvolvido em Java e utiliza conceitos de
orientação a objetos, como herança, encapsulamento e composição.

## Requisitos

- Java 17 ou superior
- Maven

## Como executar

Na raiz do projeto, execute:

```bash
mvn compile
java -cp target/classes isaiasmini.projeto.Main
```

O projeto também pode ser executado pela classe `Main` diretamente pela
IDE, como o IntelliJ IDEA.

## Funcionalidades

Ao iniciar, o sistema exibe um menu com as opções:

1. Cadastrar uma equipe, informando nome e cor.
2. Cadastrar um piloto em uma equipe existente.
3. Visualizar todas as equipes e seus pilotos.
4. Excluir um piloto pelo nome.
5. Alterar o nome de uma equipe.
0. Encerrar o programa.

Cada equipe pode ter no máximo dois pilotos. O sistema também impede nomes
ou nacionalidades vazios, idades negativas e o cadastro duplicado de uma
equipe.

## Estrutura de arquivos

### Arquivos da raiz

| Arquivo | Para que serve |
| --- | --- |
| `pom.xml` | Arquivo de configuração do Maven. Define a identificação do projeto, a versão e o uso do Java 17. |
| `.gitignore` | Informa ao Git quais arquivos e pastas não devem ser versionados, como arquivos compilados, configurações da IDE e módulos locais. |
| `README.md` | Este documento. Apresenta o objetivo, a execução e a organização do projeto. |

### Código-fonte

Os arquivos Java ficam em
`src/main/java/isaiasmini/projeto/` e pertencem ao pacote
`isaiasmini.projeto`.

| Arquivo | Para que serve |
| --- | --- |
| `Main.java` | Ponto de entrada da aplicação. Cria o sistema, lê as opções digitadas pelo usuário e chama as operações correspondentes. |
| `Pessoa.java` | Classe abstrata que representa os dados comuns de uma pessoa: nome, idade e nacionalidade. Também valida esses dados e define o método de exibição das subclasses. |
| `Piloto.java` | Representa um piloto. Herda os dados de `Pessoa` e implementa a exibição das informações do piloto. |
| `Equipe.java` | Representa uma equipe, armazenando seu nome, sua cor e uma lista de pilotos. Controla a inclusão, remoção e exibição dos pilotos, além do limite de dois pilotos. |
| `SistemaF1.java` | Centraliza as regras e operações do sistema, como cadastrar equipes e pilotos, listar equipes, alterar nomes e excluir pilotos. |

## Pastas geradas ou da IDE

Estas pastas não fazem parte do código-fonte principal e estão ignoradas
pelo Git:

| Pasta | Para que serve |
| --- | --- |
| `target/` | Criada pelo Maven para armazenar as classes compiladas e outros arquivos de build. |
| `out/` | Saída de compilação criada pela IDE ou por ferramentas de compilação. |
| `.idea/` | Configurações locais do IntelliJ IDEA para este projeto. |

## Organização do funcionamento

`Main` recebe os dados do usuário e encaminha as solicitações para
`SistemaF1`. O sistema procura a equipe correspondente e utiliza
`Equipe` para manter seus pilotos. Cada `Piloto` é uma `Pessoa`, o que
permite reutilizar os dados e validações comuns definidos na classe base.
