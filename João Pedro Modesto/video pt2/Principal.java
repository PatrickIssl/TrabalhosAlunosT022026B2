import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Produtos> estoque = new ArrayList<>();
    public static void main(String[] args) {
    mostrarMenu();
    
    }

    private static void mostrarMenu(){
        int escolha;
        do {
            System.out.println("\n----- Loja -----");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Editar produto");
            System.out.println("4 - Excluir produto");
            System.out.println("0 - Sair");
            escolha = scan.nextInt();
            scan.nextLine();
            validarEscolha(escolha);
        }while(escolha != 0);
        System.out.println("Sistema encerrado");

    }

    private static void validarEscolha(int escolha) {
        if  (escolha == 1){
            cadastrarProduto();
            return;
        }
        else if (escolha == 2){
            listarProdutos();
            return ;
        }
        else if (escolha == 3){
            editarProduto();
            return ;
        }
        else if (escolha == 4){
            excluirProduto();
            return ;
        }
    }

    private static void editarProduto() {
        listarProdutos();
        System.out.println("Selecione o produto a ser editado: ");
        int id;
        id = scan.nextInt();
        scan.nextLine();
        id--;
        for (int i = 0; i < estoque.size();i++){
            int encontrado = 0;
            if( estoque.get(id) != null){
                if (id == i){
                encontrado = 1;
                System.out.println("Insira o nome do produto:");
                estoque.get(id).setNome(scan.nextLine());
                System.out.println("Insira o valor do produto:");
                estoque.get(id).setPreco(scan.nextDouble());
                System.out.println("Insira a quantidade de produtos: ");
                estoque.get(id).setQuantidade(scan.nextInt());
                scan.nextLine();
                System.out.println("Edicao concluida com sucesso.");
                return;
                }
            }
            if (encontrado == 0){
                System.out.println("Produto não encontrado.");
                return;
            }
        }
        }

    private static void excluirProduto() {
        listarProdutos();
        System.out.println("Selecione o produto a ser excluido: ");
        int id;
        id = scan.nextInt();
        scan.nextLine();
        id--;
        int encontrado = 0;
        for (int i = 0; i < estoque.size();i++){
            
            if( estoque.get(id) != null){
                if (id == i){
                encontrado = 1;
                estoque.remove(id);
                System.out.println("Produto excluido!");
                }
            }
        }
        if (encontrado == 0){
                System.out.println("Produto não encontrado.");
                return;
            }

    }

    private static void listarProdutos() {
        if (estoque.size() < 1){
            System.out.println("Estoque vazio.");
            return ;
        }
        System.out.println("----- PRODUTOS -----");
        for (int i = 0;i < estoque.size();i++){  
        estoque.get(i).mostrarDados(i + 1);
        }
    }

    private static void cadastrarProduto() {
        Produtos produto = new Produtos();
        System.out.println("Insira o nome do produto:");
        produto.setNome(scan.nextLine());
        System.out.println("Insira o valor do produto:");
        produto.setPreco(scan.nextDouble());
        System.out.println("Insira a quantidade de produtos: ");
        produto.setQuantidade(scan.nextInt());
        scan.nextLine();
        if (produto.getNome() == null || produto.getPreco() <= 0 || produto.getQuantidade() <= 0){
            System.out.println("O cadastro nao foi concluido , tente novamente.");
            cadastrarProduto();
            return;
        }
        else {
            estoque.add(produto);
            System.out.println("Cadastro concluido com sucesso.");
        }
        
    }
}