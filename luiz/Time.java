public class Time {

    String nome;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;

    // Construtor
    public Time(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.pontos = 0;
    }

    public void registrarVitoria() {
        vitorias++;
        pontos = pontos + 3;
    }

    public void registrarEmpate() {
        empates++;
        pontos = pontos + 1;
    }

    public void registrarDerrota() {
        derrotas++;
        // derrota vale 0 pontos, entao os pontos nao mudam
    }

    public void exibirEstatisticas() {
        System.out.println("Time: " + nome);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
        System.out.println();
    }
}
