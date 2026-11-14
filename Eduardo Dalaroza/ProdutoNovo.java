public class ProdutoNovo {

    private int id;
    private String nome;
    private double preco;

    //construtuor
    public ProdutoNovo( int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    //devolve
    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    //altera
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public void exibir(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
    }



}
