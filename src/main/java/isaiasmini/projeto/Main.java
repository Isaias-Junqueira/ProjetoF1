package isaiasmini.projeto;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaF1 sistema = new SistemaF1();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA FÓRMULA 1 =====");
            System.out.println("1 - Cadastrar equipe");
            System.out.println("2 - Cadastrar piloto");
            System.out.println("3 - Visualizar equipes e pilotos");
            System.out.println("4 - Excluir piloto");
            System.out.println("5 - Alterar nome da equipe");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Nome da equipe: ");
                    String nomeEquipe = scanner.nextLine();

                    System.out.print("Cor da equipe: ");
                    String cor = scanner.nextLine();

                    sistema.cadastrarEquipe(nomeEquipe, cor);
                    break;

                case 2:
                    System.out.print("Nome do piloto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    System.out.print("Equipe: ");
                    String equipe = scanner.nextLine();

                    sistema.cadastrarPiloto(
                            nome, idade, nacionalidade, equipe
                    );
                    break;

                case 3:
                    sistema.listarEquipes();
                    break;

                case 4:
                    System.out.print("Nome do piloto que deseja excluir: ");
                    String nomeExcluir = scanner.nextLine();

                    sistema.excluirPiloto(nomeExcluir);
                    break;

                case 5:
                    System.out.print("Nome atual da equipe: ");
                    String atual = scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novo = scanner.nextLine();

                    sistema.alterarNomeEquipe(atual, novo);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

