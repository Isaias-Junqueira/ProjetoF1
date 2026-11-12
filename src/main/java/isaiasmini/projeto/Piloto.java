package isaiasmini.projeto;

public class Piloto extends Pessoa {

    public Piloto(String nome, int idade, String nacionalidade) {
        super(nome, idade, nacionalidade);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("      Nome: " + getNome());
        System.out.println("      Idade: " + getIdade());
        System.out.println("      Nacionalidade: " + getNacionalidade());
    }
}
