public class Produto {
    private final String nome;
    private final int quantidade;
    private final double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void calcularTotal() {
        System.out.printf("Total de %s: R$ %.2f%n", nome, quantidade * preco);
    }
}
