

public class Pedido {
    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche = 18.00;
    private double taxaEntrega = 7.00;
    private String status = "Aberto";

    public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getQuantidadeLanches() {
		return quantidadeLanches;
	}

	public void setQuantidadeLanches(int quantidadeLanches) {
		this.quantidadeLanches = quantidadeLanches;
	}

	public double getPrecoLanche() {
		return precoLanche;
	}

	public void setPrecoLanche(double precoLanche) {
		this.precoLanche = precoLanche;
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
        if (status.equals("Aberto") && quantidade > 0)
            quantidadeLanches += quantidade;
        else
            System.out.println("Pedido fechado!");
    }

    public double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3)
            total -= total * 0.10;

        return total + taxaEntrega;
    }

    public void finalizarPedido() {
        status = "Finalizado";
    }

    public void exibirPedido() {
        System.out.println(nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.printf("Total: R$ %.2f", calcularTotal());
        System.out.println("Status: " + status);
    }
}
