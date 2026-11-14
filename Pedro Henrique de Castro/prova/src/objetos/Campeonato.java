package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Campeonato {

    private static List<Time> listaTimes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Campeonato(Scanner scanner) {
        this.scanner = scanner;
    }

    private static Time buscarTime(String nome) {
        for (Time time : listaTimes) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                return time;
            }
        }
        return null;
    }

    public static void cadastrarTime() {
        Time time = new Time();
        System.out.println("==== Cadastrar time");
        System.out.println("Informe o nome do time");
        time.setNome(scanner.nextLine());
        listaTimes.add(time);
    }

    public static void listarTimes() {
        if (listaTimes.isEmpty()) {
            System.out.println("Não há times cadastrados");
            return;
        }

        System.out.println("==== Lista de times ====");
        for (Time time : listaTimes) {
            time.exibirDados();
        }
    }

    public static void registrarPartida() {
        if (listaTimes.size() < 2) {
            System.out.println("Cadastre pelo menos dois times");
            return;
        }

        System.out.println("==== Registrar partida ====");
        System.out.println("Informe o nome do time mandante");
        Time mandante = buscarTime(scanner.nextLine());

        System.out.println("Informe o nome do time visitante");
        Time visitante = buscarTime(scanner.nextLine());

        if (mandante == null || visitante == null) {
            System.out.println("Time não encontrado");
            return;
        }

        if (mandante == visitante) {
            System.out.println("Um time não pode jogar contra si mesmo");
            return;
        }

        System.out.println("Gols do mandante");
        int golsMandante = scanner.nextInt();
        System.out.println("Gols do visitante");
        int golsVisitante = scanner.nextInt();
        scanner.nextLine();

        if (golsMandante < 0 || golsVisitante < 0) {
            System.out.println("Os gols não podem ser negativos");
            return;
        }

        mandante.registrarJogo(golsMandante, golsVisitante);
        visitante.registrarJogo(golsVisitante, golsMandante);
        System.out.println("Partida registrada");
    }
}
