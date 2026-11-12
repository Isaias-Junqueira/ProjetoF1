package isaiasmini.projeto;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaF1 sistema = new SistemaF1();

        try {
            executarMenu(scanner, sistema);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("\nEntrada encerrada. O sistema foi finalizado.");
        } finally {
            scanner.close();
        }
    }

    private static void executarMenu(Scanner scanner, SistemaF1 sistema) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("           SISTEMA FORMULA 1");
            System.out.println("========================================");
            System.out.println("1 - Cadastrar equipe");
            System.out.println("2 - Cadastrar piloto");
            System.out.println("3 - Visualizar equipes e pilotos");
            System.out.println("4 - Excluir piloto");
            System.out.println("5 - Alterar nome da equipe");
            System.out.println("0 - Sair");
            System.out.println("----------------------------------------");

            int opcao = lerInteiro(scanner, "Escolha: ");

            switch (opcao) {
                case 1:
                    cadastrarEquipe(scanner, sistema);
                    break;
                case 2:
                    cadastrarPiloto(scanner, sistema);
                    break;
                case 3:
                    sistema.listarEquipes();
                    break;
                case 4:
                    sistema.excluirPiloto(lerTexto(scanner, "Nome do piloto que deseja excluir: "));
                    break;
                case 5:
                    String atual = lerTexto(scanner, "Nome atual da equipe: ");
                    String novo = lerTexto(scanner, "Novo nome: ");
                    sistema.alterarNomeEquipe(atual, novo);
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    return;
                default:
                    System.out.println("Opcao invalida. Escolha uma opcao do menu.");
            }
        }
    }

    private static void cadastrarEquipe(Scanner scanner, SistemaF1 sistema) {
        String nome = lerTexto(scanner, "Nome da equipe: ");
        String cor = lerTexto(scanner, "Cor da equipe: ");
        sistema.cadastrarEquipe(nome, cor);
    }

    private static void cadastrarPiloto(Scanner scanner, SistemaF1 sistema) {
        String nome = lerTexto(scanner, "Nome do piloto: ");
        int idade = lerInteiroNaoNegativo(scanner, "Idade: ");
        String nacionalidade = lerTexto(scanner, "Nacionalidade: ");
        String equipe = lerTexto(scanner, "Equipe: ");

        sistema.cadastrarPiloto(nome, idade, nacionalidade, equipe);
    }

    private static String lerTexto(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (!scanner.hasNextLine()) {
                throw new NoSuchElementException();
            }

            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }

            System.out.println("O valor nao pode ser vazio. Tente novamente.");
        }
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            String valor = lerTexto(scanner, mensagem);
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private static int lerInteiroNaoNegativo(Scanner scanner, String mensagem) {
        while (true) {
            int valor = lerInteiro(scanner, mensagem);
            if (valor >= 0) {
                return valor;
            }

            System.out.println("A idade nao pode ser negativa.");
        }
    }
}
