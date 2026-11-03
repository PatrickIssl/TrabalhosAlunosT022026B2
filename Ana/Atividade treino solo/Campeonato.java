
public class Campeonato{

    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;

    public Campeonato() {
    
    }

    public Campeonato(String nome, int vitorias, int empates, int derrotas, int pontos) {
        setNome(nome);
        setVitorias(vitorias);
        setEmpates(empates);
        setDerrotas(derrotas);
        setPontos(pontos);  
    }

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
        pontos += 1;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void exibirEstatisticas() {
        System.out.println("Nome do Campeonato: " + nome);
        System.out.println("Vitórias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }
}