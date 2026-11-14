package fag.objetos;

public class Time {
	
	private String nome;
	private int id;
	private int quantPontos;
	private int vitorias = 0;
	private int empates = 0;
	private int derrotas = 0;
	private int golsMarcados = 0;
	private int golsSofridos = 0;
	
	public Time() {
		id = 1;
	}
	
	public Time( String nome, int quantPontos, int vitorias,int empates,int derrotas,int golsMarcados,int golsSofridos) {
		
		this.nome = nome;
		this.quantPontos = quantPontos;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.golsMarcados = golsMarcados;
		this.golsSofridos = golsSofridos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantPontos() {
		return quantPontos;
	}

	public void setQuantPontos(int quantPontos) {
		this.quantPontos = quantPontos;
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

	public int getGolsMarcados() {
		return golsMarcados;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void registrarVitoria() {
		vitorias = vitorias + 1;
		quantPontos = quantPontos + 3;
		golsMarcados = golsMarcados + 3;
	}
	
	public void registrarEmpate() {
		empates = empates + 1;
		quantPontos = quantPontos + 1;
		golsMarcados = golsMarcados + 1;
	}
	
	public void registrarDerrota() {
		derrotas = derrotas + 1;
		golsSofridos = golsSofridos + golsSofridos;
	}
}
