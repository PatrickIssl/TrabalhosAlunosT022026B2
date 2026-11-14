package Fag.Objeto;

public class Time {

    private String nome;
    private int pts, vitorias, empates, derrotas, golsM, golsS;

    public Time() {
    }

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
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

	public int getGolsM() {
		return golsM;
	}

	public void setGolsM(int golsM) {
		this.golsM = golsM;
	}

	public int getGolsS() {
		return golsS;
	}

	public void setGolsF(int golsS) {
		this.golsS = golsS;
	}
	private void exibirDados() {
		
	}
}

