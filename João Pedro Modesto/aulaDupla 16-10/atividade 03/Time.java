import java.nio.channels.Pipe.SourceChannel;

public class Time {

    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;

    public Time(String nome){
    this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public int getPontos(){
        return pontos;
    }

    public void registrarVitoria(){
        vitorias++;
        pontos+=3;
    }
    public void registrarEmpate(){
        empates++;
        pontos++;
    }
    public void registrarDerrota(){
        derrotas++;
    }
    public void exibirEstatisticas(){
        System.out.println("Nome: "+nome);
        System.out.println("Vitorias: "+vitorias);
        System.out.println("Empates: "+empates);
        System.out.println("Derrotas: "+derrotas);
        System.out.println("Pontos: "+pontos);
    }
}