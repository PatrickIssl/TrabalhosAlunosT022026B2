
package produtos;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PRODUTOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: atualizar(); break;
                case 5: excluir(); break;
                case 0: System.out.println("Sistema encerrado!"); break;
                default: System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static int lerInteiro() {
        try {
            return Integer.parseInt(entrada.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Digite um numero inteiro: ");
            return lerInteiro();
        }
    }

    public static double lerDouble() {
        try {
            return Double.parseDouble(entrada.nextLine().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.print("Digite um preco valido: ");
            return lerDouble();
        }
    }

    public static Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static void cadastrar() {

        System.out.print("ID: ");
        int id = lerInteiro();

        if (buscarProduto(id) != null) {
            System.out.println("ID ja cadastrado!");
            return;
        }

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Categoria: ");
        String categoria = entrada.nextLine();

        System.out.print("Preco: R$ ");
        double preco = lerDouble();

        if (preco < 0) {
            System.out.println("Preco nao pode ser negativo!");
            return;
        }

        produtos.add(new Produto(id, nome, categoria, preco));
        System.out.println("Produto cadastrado!");
    }

    public static void listar() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            p.exibirDados();
        }
    }

    public static void buscar() {

        System.out.print("Digite o ID: ");
        Produto p = buscarProduto(lerInteiro());

        if (p == null) {
            System.out.println("Produto nao encontrado!");
        } else {
            p.exibirDados();
        }
    }

    public static void atualizar() {

        System.out.print("Digite o ID: ");
        Produto p = buscarProduto(lerInteiro());

        if (p == null) {
            System.out.println("Produto nao encontrado!");
            return;
        }

        System.out.print("Novo nome: ");
        p.setNome(entrada.nextLine());

        System.out.print("Nova categoria: ");
        p.setCategoria(entrada.nextLine());

        System.out.print("Novo preco: R$ ");
        double preco = lerDouble();

        if (preco < 0) {
            System.out.println("Preco nao pode ser negativo!");
            return;
        }

        p.setPreco(preco);
        System.out.println("Produto atualizado!");
    }

    public static void excluir() {

        System.out.print("Digite o ID: ");
        Produto p = buscarProduto(lerInteiro());

        if (p == null) {
            System.out.println("Produto nao encontrado!");
        } else {
            produtos.remove(p);
            System.out.println("Produto excluido!");
        }
    }
}
