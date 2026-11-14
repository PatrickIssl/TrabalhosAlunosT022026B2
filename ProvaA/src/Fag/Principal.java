
package Fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Fag.Objeto.Campeonato;
import Fag.Objeto.Time;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static List<Time> listaLivros = new ArrayList<Time>();
    static List<Campeonato> listaUsuarios = new ArrayList<Campeonato>();

    public static void main(String[] args) {
        System.out.println("Sistema do Campeonato iniciado!");
        mostrarMenu();
    }

 

    public static void mostrarMenu() {
        int escolhaUsuario = 0;

        do {
            System.out.println("\n-------- BRASILEIRÃO 2027 --------");
            System.out.println("1 - Listar times");
            System.out.println("2 - Cadastrar Time");
            System.out.println("3 - Registrar Partida");
            System.out.println("4 - Classificação");
            System.out.println("0 - Sair");
            System.out.println("------------------------------------");
            System.out.println("Escolha uma opcao:");

            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0: {
                System.out.println("Sistema encerrado!");
                break;
            }
            case 1: {
                listarTimes();
                break;
            }
            case 2: {
                cadastrarTime();
                break;
            }
            case 3: {
                registrarPartida();
                break;
            }
            case 4: {
                mostrarTabela();
                break;
            }
            default:
                System.out.println("Insira um valor valido!");
        }
    }

    private static void listarTimes() {
        System.out.println("\n-------- LISTA DE TIMES --------");

        if (listaLivros.size() == 0) {
            System.out.println("Nenhum time cadastrado!");
            return;
        }

        for (int i = 0; i < listaLivros.size(); i++) {
            System.out.printf("%d) %s \n",
                    i + 1,
                    listaLivros.get(i).getNome());
        }

        System.out.println("");
    }

    private static void cadastrarTime() {
        Time time = new Time();
        System.out.println("\n-------~ CADASTRAR TIME ~-------");
        System.out.println("Informe o nome do time:");
        time.setNome(scan.nextLine());
        listaLivros.add(time);
        System.out.println("Time cadastrado com sucesso!");
    }

    private static void registrarPartida() {
        if (listaLivros.size() == 0) {
            System.out.println("Nao existem times suficientes para competir!");
            return;
        }

        listarTimes();

        System.out.println("Informe o time mandante:");
        int escolhaUsuario = scan.nextInt() - 1;
        scan.nextLine();
    }

    private static void mostrarTabela() {
        if (listaUsuarios.size() == 0) {
            System.out.println("Nenhum time para mostrar!");
            return;
        }

        listarTimes();

    }
}