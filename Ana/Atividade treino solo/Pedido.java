
public class Pedido {
    private String nome;
    private int qtd;
    private double preco = 18.00;
    private double taxaEntrega = 7.00;
    private String status;

    public Pedido() {
        status = "Aberto";
    }

    public Pedido(String nome, int qtd, double preco, double taxaEntrega, String status) {
        setNome(nome);
        setQtd(qtd);
        setPreco(preco);
        setTaxaEntrega(taxaEntrega);
        setStatus(status);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionarLanches(int quantidade) {
        if (status.equalsIgnoreCase("Fechado")) {
            System.out.println("Não é possível adicionar lanches, o pedido já está fechado.");
            return;
        }

        if (quantidade > 0) {
            qtd += quantidade;
            System.out.println("Lanche adicionado com sucesso!");
        } else {
            System.out.println("A quantidade deve ser maior que zero.");
        }
    }

    public void calcularTotal() {
        double total = qtd * preco;

        if (qtd >= 3) {
            total = total - (total * 0.10);
        }

        total = total + taxaEntrega;

        System.out.println("Total do pedido: R$ " + String.format("%.2f", total));
    }

    public void finalizarPedido() {
        if (status.equalsIgnoreCase("Aberto")) {
            System.out.println("Pedido finalizado com sucesso!");
            status = "Fechado";
        } else {
            System.out.println("O pedido já está fechado.");
        }
    }

    public void exibirPedido() {
        System.out.println("\nResumo do Pedido:");
        System.out.println("Nome do Cliente: " + nome);
        System.out.println("Quantidade de Lanches: " + qtd);
        System.out.println("Preço do Lanche: R$ " + String.format("%.2f", preco));
        System.out.println("Taxa de Entrega: R$ " + String.format("%.2f", taxaEntrega));
        System.out.println("Status do Pedido: " + status);
    }
}
