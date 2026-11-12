

public class Cadastro {
    private final String nome;
    private int idade;
    private final String cidade;

    public Cadastro(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + ".");
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);
    }

    public void fazerAniversario() {
        idade++;
    }
}
