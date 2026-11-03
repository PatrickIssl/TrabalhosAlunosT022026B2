
public class App {
   public static void main(String[] args) {
        Time time1 = new Time("Gremio");
        Time time2 = new Time("Inte");

        time1.registrarVitoria();
        time1.registrarVitoria();
        time1.registrarVitoria();

        time2.registrarDerrota();
        time2.registrarDerrota();
        time2.registrarDerrota();

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.pontos > time2.pontos) {
            System.out.println(time1.nome + " tem mais pontos!");
        } else if (time2.pontos > time1.pontos) {
            System.out.println(time2.nome + " tem mais pontos!");
        } else {
            System.out.println("Houve empate na classificação!");
        }
    }
}

