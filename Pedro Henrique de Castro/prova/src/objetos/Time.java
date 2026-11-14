package objetos;

public class Time {
    private String nome;
    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsMarcados;
    private int golsSofridos;

    public Time(String nome, int pontos, int vitorias, int empates, int derrotas, int golsMarcados, int golsSofridos) {
        this.nome = nome;
        this.pontos = pontos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golsMarcados = golsMarcados;
        this.golsSofridos = golsSofridos;
    }

    public Time() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
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

    public void registrarJogo(int golsPro, int golsContra) {
        golsMarcados += golsPro;
        golsSofridos += golsContra;

        if (golsPro > golsContra) {
            vitorias++;
            pontos += 3;
        } else if (golsContra == golsPro) {
            empates++;
            pontos += 1;
        } else {
            derrotas++;
        }
    }

    public void exibirDados() {
        System.out.printf("%s | Pontos: %d | Vitorias: %d | Empates: %d | Derrotoas: %d | Gols marcados: %d | Gols sofridos: %d\n", nome, pontos, vitorias, empates, derrotas, golsMarcados, golsSofridos );
    }
}
