import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Produto> lista = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);
    static int contador = 1;

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
            System.out.print("Escolha uma opcao: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                cadastrar();
            } else if (opcao == 2) {
                listar();
            } else if (opcao == 3) {
                buscar();
            } else if (opcao == 4) {
                atualizar();
            } else if (opcao == 5) {
                excluir();
            } else if (opcao == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        entrada.close();
    }

    static void cadastrar() {
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Preco: ");
        double preco = entrada.nextDouble();
        entrada.nextLine();

        Produto p = new Produto(contador, nome, preco);
        lista.add(p);
        contador++;
        System.out.println("Produto cadastrado!");
    }

    static void listar() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
        } else {
            for (Produto p : lista) {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preco: " + p.getPreco());
            }
        }
    }

    static void buscar() {
        System.out.print("Digite o ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        boolean achou = false;
        for (Produto p : lista) {
            if (p.getId() == id) {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preco: " + p.getPreco());
                achou = true;
            }
        }
        if (achou == false) {
            System.out.println("ID nao encontrado!");
        }
    }

    static void atualizar() {
        System.out.print("Digite o ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        boolean achou = false;
        for (Produto p : lista) {
            if (p.getId() == id) {
                System.out.print("Novo nome: ");
                String nome = entrada.nextLine();
                System.out.print("Novo preco: ");
                double preco = entrada.nextDouble();
                entrada.nextLine();
                p.setNome(nome);
                p.setPreco(preco);
                System.out.println("Produto atualizado!");
                achou = true;
            }
        }
        if (achou == false) {
            System.out.println("ID nao encontrado!");
        }
    }

    static void excluir() {
        System.out.print("Digite o ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        boolean achou = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                System.out.println("Produto excluido!");
                achou = true;
                break;
            }
        }
        if (achou == false) {
            System.out.println("ID nao encontrado!");
        }
    }
}
