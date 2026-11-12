package isaiasmini.projeto;

public abstract class Pessoa {

    private String nome;
    private int idade;
    private String nacionalidade;

    public Pessoa(String nome, int idade, String nacionalidade) {
        setNome(nome);
        setIdade(idade);
        setNacionalidade(nacionalidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        if (nacionalidade == null || nacionalidade.isBlank()) {
            throw new IllegalArgumentException("A nacionalidade não pode ser vazia.");
        }
        this.nacionalidade = nacionalidade;
    }

    // Cada classe filha define como seus dados devem ser exibidos.
    public abstract void exibirInformacoes();
}
