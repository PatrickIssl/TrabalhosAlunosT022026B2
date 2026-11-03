package Principal;


import java.util.Scanner;

class Time {

    String nome;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;

    static Scanner scanner = new Scanner(System.in);

    public Time(String nometime) {
        nome = nometime;
        vitorias = 0;
        empates = 0;
        derrotas = 0;
        pontos = 0;
    }

    public void registrarVitoria() {
        System.out.println("Registrar vitoria do time " + nome);
        System.out.println("Digite quantas vitorias quer adicionar:");
        int vitoria = scanner.nextInt();

        if (vitoria > 0) {
            vitorias += vitoria;
            pontos = (vitorias * 3) + empates;
        } else {
            System.out.println("Erro: digite uma quantidade positiva.");
        }
    }

    public void registrarEmpate() {
        System.out.println("Registrar empate do time " + nome);
        System.out.println("Digite quantos empates quer adicionar:");
        int empate = scanner.nextInt();

        if (empate > 0) {
            empates += empate;
            pontos = (vitorias * 3) + empates;
        } else {
            System.out.println("Erro: digite uma quantidade positiva.");
        }
    }

    public void registrarDerrota() {
        System.out.println("Registrar derrota do time " + nome);
        System.out.println("Digite quantas derrotas quer adicionar:");
        int derrota = scanner.nextInt();

        if (derrota > 0) {
            derrotas += derrota;
        } else {
            System.out.println("Erro: digite uma quantidade positiva.");
        }
    }

    public void exibirEstatisticas() {
        System.out.println("\nEstatisticas do time " + nome);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }
}

public class Campeonato {

    public static void main(String[] args) {

        Scanner scanner = Time.scanner;

        System.out.println("Digite o nome do time 1:");
        String nome1 = scanner.nextLine();

        Time time1 = new Time(nome1);

        time1.registrarVitoria();
        time1.registrarDerrota();
        time1.registrarEmpate();
        scanner.nextLine();

        System.out.println("\nDigite o nome do time 2:");
        String nome2 = scanner.nextLine();

        Time time2 = new Time(nome2);

        time2.registrarVitoria();
        time2.registrarDerrota();
        time2.registrarEmpate();

        System.out.println("\n ESTATISTICAS FINAIS");

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        System.out.println("\nQUEM GANHOU?");

        if (time1.pontos > time2.pontos) {
            System.out.println(nome1 + " tem mais pontos!");
        } else if (time2.pontos > time1.pontos) {
            System.out.println(nome2 + " tem mais pontos!");
        } else {
            System.out.println("Empate!");
        }

        scanner.close();
    }
}