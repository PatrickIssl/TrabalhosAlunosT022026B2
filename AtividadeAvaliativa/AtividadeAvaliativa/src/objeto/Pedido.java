package objeto;


public class Pedido {
	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanches;
	private double taxaEntrega;
	private boolean status;
	public Pedido() {
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		if (nomeCliente!=null && !nomeCliente.isBlank()) {
			this.nomeCliente = nomeCliente;
		}else {
			System.out.println("O nome não pode estar vaio!");
		}
	
	}
	public int getQuantidadeLanches() {
		return quantidadeLanches;
	}
	public void setQuantidadeLanches(int quantidadeLanches) {
		if (quantidadeLanches > 0) {
			this.quantidadeLanches = quantidadeLanches;
		}else {
			System.out.println("A quantidade não pode ser 0 ou negativo");
		}
	}
	public double getPrecoLanches() {
		return precoLanches;
	}
	public void setPrecoLanches(double precoLanches) {
		if (precoLanches > 0) {
			this.precoLanches = precoLanches;
		}else {
			System.out.println("O valor não pode ser zero ou negativo");
		}
		
	}
	public double getTaxaEntrega() {
		return taxaEntrega;
	}
	public void setTaxaEntrega(double taxaEntrega) {
		if (taxaEntrega > 0) {
			this.taxaEntrega = taxaEntrega;
		}else {
			System.out.println("O valor não pode ser zero ou negativo");
		}
		
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void adicionarLanches(int quantidade) {
		if (this.status != true) {
			if (quantidade > 0) {
				this.quantidadeLanches = quantidade;	
			}else {
				System.out.println("O valor nao pode ser zero ou negativo");
			}
		}else {
			System.out.println("Não foi possivel, o pedido esta finalizado!");
		}
	}
	public void calcularTotal () {
		double desconto;
		if (this.quantidadeLanches >=3) {
			this.precoLanches= (this.quantidadeLanches * this.precoLanches);
			desconto= this.precoLanches*0.10;
			this.precoLanches -=desconto;
			this.precoLanches += this.taxaEntrega;
		}else {
			this.precoLanches = this.taxaEntrega+(this.quantidadeLanches * this.precoLanches);
		}	
	}
	public void finalizarPedido() {
		this.status = true;
	}
	public void exibirPedido () {
		System.out.println("Cliente: "+this.nomeCliente+ " Qauntidade: "+this.quantidadeLanches+" Valor: "+this.precoLanches+ "R$ Finalizado: "+this.status);
		
	}
}
