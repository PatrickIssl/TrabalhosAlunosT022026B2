
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = entrada.nextLine();

        Pedido pedido = new Pedido(nome);

        System.out.print("Quantos lanches deseja adicionar na primeira vez? ");
        int quantidade1 = entrada.nextInt();
        pedido.adicionarLanches(quantidade1);

        System.out.print("Quantos lanches deseja adicionar na segunda vez? ");
        int quantidade2 = entrada.nextInt();
        pedido.adicionarLanches(quantidade2);

        pedido.exibirPedido();

        pedido.finalizarPedido();

        System.out.print("Tente adicionar mais lanches: ");
        int quantidade3 = entrada.nextInt();
        pedido.adicionarLanches(quantidade3);

        pedido.exibirPedido();

        entrada.close();
    }
}
