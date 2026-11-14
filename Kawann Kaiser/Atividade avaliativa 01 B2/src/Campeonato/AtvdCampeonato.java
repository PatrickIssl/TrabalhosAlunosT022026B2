
package Campeonato;

import java.util.Scanner;

public class AtvdCampeonato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Campeonato time1 = new Campeonato();
        Campeonato time2 = new Campeonato();

        System.out.println("Informe o nome do primeiro time:");
        time1.nome = scanner.nextLine();

        System.out.println("Informe o nome do segundo time:");
        time2.nome = scanner.nextLine();

        int opcao;
        int escolhaTime;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1 - Registrar vitoria");
            System.out.println("2 - Registrar empate");
            System.out.println("3 - Registrar derrota");
            System.out.println("4 - Exibir estatisticas");
            System.out.println("5 - Exibir classificacao");
            System.out.println("6 - Sair");
            System.out.println("Informe a opcao desejada:");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("1 - " + time1.nome);
                    System.out.println("2 - " + time2.nome);
                    escolhaTime = scanner.nextInt();

                    if (escolhaTime == 1) {
                        time1.registrarVitoria();
                    }
                    else if (escolhaTime == 2) {
                        time2.registrarVitoria();
                    }
                    else {
                        System.out.println("Time invalido");
                    }
                    break;

                case 2:
                    System.out.println("1 - " + time1.nome);
                    System.out.println("2 - " + time2.nome);
                    escolhaTime = scanner.nextInt();

                    if (escolhaTime == 1) {
                        time1.registrarEmpate();
                    }
                    else if (escolhaTime == 2) {
                        time2.registrarEmpate();
                    }
                    else {
                        System.out.println("Time invalido");
                    }
                    break;

                case 3:
                    System.out.println("1 - " + time1.nome);
                    System.out.println("2 - " + time2.nome);
                    escolhaTime = scanner.nextInt();

                    if (escolhaTime == 1) {
                        time1.registrarDerrota();
                    }
                    else if (escolhaTime == 2) {
                        time2.registrarDerrota();
                    }
                    else {
                        System.out.println("Time invalido");
                    }
                    break;

                case 4:
                    time1.exibirEstatisticas();
                    time2.exibirEstatisticas();
                    break;

                case 5:
                    if (time1.pontos > time2.pontos) {
                        System.out.println("Lider: " + time1.nome);
                    }
                    else if (time2.pontos > time1.pontos) {
                        System.out.println("Lider: " + time2.nome);
                    }
                    else {
                        System.out.println("Empate na classificacao");
                    }
                    break;

                case 6:
                    System.out.println("Finalizando programa");
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        } while (opcao != 6);

        scanner.close();
    }
}

