public class Produtos {

    private String nome;
    private double preco;
    private int quantidade;

    public Produtos() {

    }

    public Produtos(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()){
        System.out.println("Nome invalido");
        return;
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0){
            System.out.println("Preco invalido");
            return ;
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0){
            System.out.println("Quantidade invalida");
        }
        this.quantidade = quantidade;
    }

    public void mostrarDados(int posicao){
        System.out.printf("%d - %s - R$ %.2f - %d \n",posicao,getNome(),getPreco(),getQuantidade());
    }

    
    


}