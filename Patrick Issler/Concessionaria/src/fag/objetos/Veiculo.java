package fag.objetos;

public class Veiculo {

	private String cor;
	private String placa;
	private String modelo;
	private int ano;
	
	public Veiculo() {
		
	}

	public Veiculo(String cor, String placa, String modelo, int ano) {
		setCor(cor);
		setPlaca(placa);
		setModelo(modelo);
		setAno(ano);
	}

	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		if(cor.isBlank()) {
			System.out.println("Cor inválida!");
			return;
		}
		this.cor = cor;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		if(placa.isBlank()) {
			System.out.println("Placa inválida!");
			return;
		}
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		if(modelo.isBlank()) {
			System.out.println("Modelo inválida!");
			return;
		}
		this.modelo = modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		if(ano < 1850 ) {
			System.out.println("Ano inválido");
			return;
		}
		this.ano = ano;
	}
	
	public void mostrarDados(int posicao) {
		System.out.printf(" %d) %s - %s -%s / %d\n", posicao ,getModelo(), getCor(), getPlaca(), getAno());
	}
	
	
	
	
	
	
	
}
