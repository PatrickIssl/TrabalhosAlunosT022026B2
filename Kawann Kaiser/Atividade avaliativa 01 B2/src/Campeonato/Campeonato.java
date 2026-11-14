
package Campeonato;

public class Campeonato {

    String nome;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;

    void registrarVitoria() {
        vitorias++;
        pontos = pontos + 3;
        System.out.println("Vitoria registrada para o time: " + nome);
    }

    void registrarEmpate() {
        empates++;
        pontos = pontos + 1;
        System.out.println("Empate registrado para o time: " + nome);
    }

    void registrarDerrota() {
        derrotas++;
        System.out.println("Derrota registrada para o time: " + nome);
    }

    void exibirEstatisticas() {
        System.out.println("\n===== ESTATISTICAS DO TIME =====");
        System.out.println("Time: " + nome);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }
}
