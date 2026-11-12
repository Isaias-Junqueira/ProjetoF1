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
            throw new IllegalArgumentException("O nome da equipe não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException("A cor da equipe não pode ser vazia.");
        }
        this.cor = cor;
    }

    public List<Piloto> getPilotos() {
        // A lista somente para leitura impede alterações fora desta classe.
        return Collections.unmodifiableList(pilotos);
    }

    public boolean adicionarPiloto(Piloto piloto) {
        if (piloto == null) {
            return false;
        }
        if (pilotos.size() >= 2) {
            System.out.println("A equipe já possui dois pilotos.");
            return false;
        }
        pilotos.add(piloto);
        return true;
    }

    public void exibirEquipe() {
        System.out.println("Equipe: " + nome);
        System.out.println("Cor: " + getCor());
        System.out.println("Pilotos:");

        if (pilotos.isEmpty()) {
            System.out.println("Nenhum piloto cadastrado.");
            return;
        }

        for (Piloto piloto : pilotos) {
            piloto.exibirInformacoes();
        }
    }

    // A exclusão é centralizada aqui para preservar o encapsulamento da lista.
    public boolean removerPiloto(Piloto piloto) {
        return pilotos.remove(piloto);
    }
}
