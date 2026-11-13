package atividadeavaliativa;

public class Time {

    String nome;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;

    public Time(String nomeDoTime) {
        nome = nomeDoTime;
        vitorias = 0;
        empates = 0;
        derrotas = 0;
        pontos = 0;
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
        System.out.println("--- Estatísticas do Time ---");
        System.out.println("Nome: " + nome);
        System.out.println("Vitórias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos Totais: " + pontos);
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        
        Time timeA = new Time("Flamengo");
        
        timeA.registrarVitoria();
        timeA.registrarVitoria();
        timeA.registrarEmpate();
        timeA.registrarDerrota();

        Time timeB = new Time("Palmeiras");
        
        timeB.registrarVitoria();
        timeB.registrarEmpate();
        timeB.registrarEmpate();
        timeB.registrarDerrota();

        timeA.exibirEstatisticas();
        timeB.exibirEstatisticas();

        System.out.println("=== RESULTADO FINAL ===");

        if (timeA.pontos > timeB.pontos) {
            System.out.println("O time " + timeA.nome + " possui mais pontos!");
        } else if (timeB.pontos > timeA.pontos) {
            System.out.println("O time " + timeB.nome + " possui mais pontos!");
        } else {
            System.out.println("Houve empate na classificação.");
        }
    }
}
