package fag.objetos;

public class Jogo {
	private String nome;
	private String genero;
	
	public Jogo() {
	}

	public Jogo(String nome, String genero) {
		if (nome.isBlank() || genero.isBlank()) {
			System.out.println("Informe um nome e um genêro válido!");
			return;
		}
		setNome(nome);
		setGenero(genero);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome.isBlank()) {
			System.out.println("Informe um nome válido!");
			return;
		}
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		if (genero.isBlank()) {
			System.out.println("Informe um genero válido!");
			return;
		}
		this.genero = genero;
	}
	
	

}
