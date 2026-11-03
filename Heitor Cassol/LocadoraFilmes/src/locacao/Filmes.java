package locacao;

public class Filmes {
    String nome;
    int ano;
    String diretor;
    boolean disponivel;

    public Filmes(String nome, int ano, String diretor) {
        this.nome = nome;
        this.ano = ano;
        this.diretor = diretor;
        this.disponivel = true;
    }

    public void exibirFilme() {
        System.out.println("Filme: " + nome);
        System.out.println("Ano: " + ano);
        System.out.println("Diretor: " + diretor);
        System.out.println("Disponível: " + disponivel);
    }
}
