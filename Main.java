package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produto> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: atualizar(); break;
                case 5: excluir(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();
        lista.add(new Produto(proximoId, nome, preco));
        System.out.println("Cadastrado com ID: " + proximoId);
        proximoId++;
    }

    static void listar() {
        if (lista.isEmpty()) { System.out.println("Nenhum produto cadastrado."); return; }
        for (Produto p : lista) {
            System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preço: R$" + p.getPreco());
        }
    }

    static void buscar() {
        System.out.print("ID para buscar: ");
        int id = sc.nextInt(); sc.nextLine();
        for (Produto p : lista) if (p.getId() == id) {
            System.out.println("Achou -> ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preço: R$" + p.getPreco());
            return;
        }
        System.out.println("ID não existe!");
    }

    static void atualizar() {
        System.out.print("ID para atualizar: ");
        int id = sc.nextInt(); sc.nextLine();
        for (Produto p : lista) if (p.getId() == id) {
            System.out.print("Novo nome: "); p.setNome(sc.nextLine());
            System.out.print("Novo preço: "); p.setPreco(sc.nextDouble()); sc.nextLine();
            System.out.println("Atualizado!");
            return;
        }
        System.out.println("ID não existe!");
    }

    static void excluir() {
        System.out.print("ID para excluir: ");
        int id = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < lista.size(); i++) if (lista.get(i).getId() == id) {
            lista.remove(i);
            System.out.println("Removido!");
            return;
        }
        System.out.println("ID não existe!");
    }
}