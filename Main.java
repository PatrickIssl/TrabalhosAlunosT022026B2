package aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Aluno> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - BUSCAR POR ID");
            System.out.println("0 - SAIR");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    System.out.print("Digite o ID para buscar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Aluno encontrado = buscarPorId(id);
                    if (encontrado != null) {
                        System.out.println("Achou: " + encontrado.getNome() + " - Nota: " + encontrado.getNota());
                    } else {
                        System.out.println("Aluno nao encontrado!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();
        
        int id = lista.size() + 1;
        Aluno novo = new Aluno(id, nome, nota);
        lista.add(novo);
        System.out.println("Aluno cadastrado com ID: " + id);
    }

    static Aluno buscarPorId(int id) {
        for (Aluno a : lista) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
}