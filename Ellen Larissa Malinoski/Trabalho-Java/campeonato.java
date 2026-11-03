
public class campeonato {
	private String nome;
	private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
        vitorias++;
        pontos += 3;
    }

    public void registrarEmpate() {
        empates++;
        pontos++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void exibirEstatisticas() {
        System.out.println(nome);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Pontos: " + pontos);
    }
}
    

