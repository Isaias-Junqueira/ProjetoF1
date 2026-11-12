package isaiasmini.projeto;

import java.util.ArrayList;
import java.util.List;

public class SistemaF1 {

    private final List<Equipe> equipes;

    public SistemaF1() {
        this.equipes = new ArrayList<>();
    }

    public void cadastrarEquipe(String nome, String cor) {
        if (buscarEquipe(nome) != null) {
            System.out.println("A equipe já está cadastrada.");
            return;
        }

        Equipe equipe = new Equipe(nome, cor);
        equipes.add(equipe);
        System.out.println("Equipe cadastrada com sucesso!");
    }

    public void cadastrarPiloto(
            String nome,
            int idade,
            String nacionalidade,
            String nomeEquipe) {
        Equipe equipe = buscarEquipe(nomeEquipe);
        if (equipe == null) {
            System.out.println("Equipe não encontrada.");
            return;
        }

        Piloto piloto = new Piloto(nome, idade, nacionalidade);

        if (equipe.adicionarPiloto(piloto)) {
            System.out.println("Piloto cadastrado com sucesso na equipe " + nomeEquipe + "!");
        } else {
            System.out.println("Não foi possível cadastrar o piloto na equipe " + nomeEquipe + ".");
        }
    }

    private Equipe buscarEquipe(String nome) {
        if (nome == null) {
            return null;
        }
        for (Equipe equipe : equipes) {
            if (equipe.getNome().equalsIgnoreCase(nome)) {
                return equipe;
            }
        }
        return null;
    }

    public void listarEquipes() {
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe cadastrada.");
            return;
        }
        for (Equipe equipe : equipes) {
            equipe.exibirEquipe();
            System.out.println("--------------------");
        }
    }

    public void alterarNomeEquipe(String nomeAtual, String novoNome) {

        Equipe equipe = buscarEquipe(nomeAtual);

        if (equipe != null) {
            equipe.setNome(novoNome);
            System.out.println("Nome da equipe alterado com sucesso!");
        } else {
            System.out.println("Equipe não encontrada.");
        }
    }

    public void excluirPiloto(String nomePiloto) {
        for (Equipe equipe : equipes) {
            for (Piloto piloto : equipe.getPilotos()) {
                if (piloto.getNome().equalsIgnoreCase(nomePiloto)) {
                    equipe.removerPiloto(piloto);
                    System.out.println("Piloto removido!");
                    return;
                }
            }
        }

        System.out.println("Piloto não encontrado.");
    }
}
