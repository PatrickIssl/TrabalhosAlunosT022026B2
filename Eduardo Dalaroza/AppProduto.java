import java.util.ArrayList;
import java.util.Scanner;

public class AppProduto {

    static int proximoId = 1;

    static void cadastrar(ArrayList<ProdutoNovo> lista, Scanner entrada) {

        System.out.println("Digite o nome do produto: ");
        String nome = entrada.nextLine();

        System.out.println("Digite o valor do produto: ");
        double preco = entrada.nextDouble();
        entrada.nextLine();

        ProdutoNovo p1 = new ProdutoNovo(proximoId, nome, preco);
        lista.add(p1);

        proximoId++;
        System.out.println("Cadastrado com sucesso!");

    }

    static void listar(ArrayList<ProdutoNovo> lista) {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }

        for (ProdutoNovo p1 : lista) {
            p1.exibir();
            System.out.println("-------------------");

        }
    }

    static void buscar(ArrayList<ProdutoNovo> lista, Scanner entrada) {

        System.out.println("Digite o ID do produto:");
        int id = entrada.nextInt();
        entrada.nextLine();

        boolean encontrado = false;

        for(ProdutoNovo p1 : lista){
            if (p1.getId() == id) {
                encontrado = true;
                p1.exibir();
                break;
            }
        }
        if(!encontrado){
            System.out.println("ID não encontrado");
        }
    }

    static ProdutoNovo buscarporId(ArrayList<ProdutoNovo> lista, int id){
        for(ProdutoNovo p1 : lista){
            if(p1.getId() == id){
                return p1;
            }
        }
        return null;
    }

    static void atualizar(ArrayList<ProdutoNovo> lista, Scanner entrada) {
        System.out.println("Digite o ID do produto: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        ProdutoNovo p1 = buscarporId(lista, id);
        if(p1 == null){
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("Novo produto: ");
        String nome = entrada.nextLine();
        System.out.println("Novo preço: ");
        double preco = entrada.nextDouble();
        entrada.nextLine();

        p1.setNome(nome);
        p1.setPreco(preco);
        System.out.println("Atualizado com sucesso!");

    }

    static void excluir(ArrayList<ProdutoNovo> lista, Scanner entrada) {
        System.out.println("Digite o ID do produto: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        ProdutoNovo p1 = buscarporId(lista, id);

        if(p1 == null){
            System.out.println("Não encontrado.");
            return;
        }
        lista.remove(p1);
        System.out.println("Removido com sucesso!");

    }


    public static void main(String[] args) {

        ArrayList<ProdutoNovo> lista = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("==========Sistema de Gerenciamento==========\n");
            System.out.println("1 - Cadastrar\n" +
                    "2 - Listar todos\n" +
                    "3 - Buscar por ID\n" +
                    "4 - Atualizar\n" +
                    "5 - Excluir\n" +
                    "0 - Sair\n");
            System.out.println("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar(lista, entrada);
                    break;
                case 2:
                    listar(lista);
                    break;
                case 3:
                    buscar(lista, entrada);
                    break;
                case 4:
                    atualizar(lista, entrada);
                    break;
                case 5:
                    excluir(lista, entrada);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um valor válido!");
                    break;
            }

        } while (opcao != 0);

    }
}
