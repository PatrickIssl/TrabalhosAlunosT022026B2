package principal;

import objetos.Campeonato;
import objetos.Time;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Time> listaTimes = new ArrayList<>();
    static ArrayList<Campeonato> listaCampeonatos = new ArrayList<>();

    public static void mostrarMenu() {
        int escolha = 0;
        do {
            System.out.println("==== Campeonato Brasileiro ====");
            System.out.println("1 - Cadastrar time");
            System.out.println("2 - Listar times");
            System.out.println("3 - Registrar partida");
            System.out.println("4 - Exibir classificação");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();
            validarEscolha(escolha);
        } while (escolha != 0);
    }

    public static void validarEscolha(int escolha) {
        switch (escolha) {
            case 1:
                Campeonato.cadastrarTime();
                break;
            case 2:
                Campeonato.listarTimes();
                break;
            case 3:
                Campeonato.registrarPartida();
                break;
            case 4:
                break;
            case 0:
                System.out.println("Sistema finalizado");
                break;
        }
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}