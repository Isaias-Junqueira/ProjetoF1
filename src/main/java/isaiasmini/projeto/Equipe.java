package isaiasmini.projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipe {

    private String nome;
    private String cor;
    private final List<Piloto> pilotos;

    public Equipe(String nome, String cor) {
        setNome(nome);
        setCor(cor);
        this.pilotos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da equipe nao pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException("A cor da equipe nao pode ser vazia.");
        }
        this.cor = cor;
    }

    public List<Piloto> getPilotos() {
        return Collections.unmodifiableList(pilotos);
    }

    public boolean adicionarPiloto(Piloto piloto) {
        if (piloto == null) {
            return false;
        }
        if (pilotos.size() >= 2) {
            System.out.println("A equipe ja possui dois pilotos.");
            return false;
        }
        pilotos.add(piloto);
        return true;
    }

    public void exibirEquipe() {
        System.out.println("\n========================================");
        System.out.println("Equipe: " + nome);
        System.out.println("Cor: " + cor);
        System.out.println("----------------------------------------");

        if (pilotos.isEmpty()) {
            System.out.println("Pilotos: nenhum piloto cadastrado.");
        } else {
            System.out.println("Pilotos:");
            for (int i = 0; i < pilotos.size(); i++) {
                System.out.println("  [" + (i + 1) + "] ----------------------------");
                pilotos.get(i).exibirInformacoes();
            }
        }

        System.out.println("========================================");
    }

    public boolean removerPiloto(Piloto piloto) {
        return pilotos.remove(piloto);
    }
}
