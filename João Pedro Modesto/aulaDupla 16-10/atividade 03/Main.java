import java.nio.channels.Pipe.SourceChannel;

public class Main {
    public static void main(String[] args) {
        Time santos = new Time("Santos");
        Time palmeiras = new Time("palmeiras");
        santos.registrarEmpate();
        palmeiras.registrarDerrota();
        santos.registrarVitoria();
        palmeiras .registrarEmpate();
        santos.exibirEstatisticas();
        palmeiras.exibirEstatisticas();
        comparaResult(santos, palmeiras);
    }

    public static void comparaResult(Time a, Time b){
        if (a.getPontos() > b.getPontos()){
            System.out.println("O time "+a.getNome()+" possui mais pontos");
        }
        else if (a.getPontos() == b.getPontos()){
        System.out.println("Ambos os times tiveram a mesma pontuação.");
        }
        else {
          System.out.println("O time "+b.getNome()+" possui mais pontos");  
        }
    }
}
