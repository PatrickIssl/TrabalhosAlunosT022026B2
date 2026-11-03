package objeto;

public class Time {
	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;
	public Time() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}else {
			System.out.println("O nome não é válido");
		}
		
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public void registrarVitoria() {
		this.vitorias+=1;
		this.pontos+=3;
	}
	public void registrarEmpate() {
		this.empates+=1;
		this.pontos+=1;
	}
	public void registrarDerrota () {
		this.derrotas=1;
	}
	public void exibirEstatisticas() {
		System.out.println("Time: "+this.nome+" Vitorias: "+this.vitorias+" Empates: "+this.empates+" Derrotas: "+this.derrotas+ " Pontos: "+this.pontos);
	}
}
