
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome do dono: ");
        String dono = entrada.nextLine();

        System.out.print("Digite a meta de economia: R$ ");
        double meta = entrada.nextDouble();

        Cofrinho cofrinho = new Cofrinho(dono, meta);

        System.out.print("Digite o primeiro deposito: R$ ");
        double deposito1 = entrada.nextDouble();
        cofrinho.depositar(deposito1);

        System.out.print("Digite o segundo deposito: R$ ");
        double deposito2 = entrada.nextDouble();
        cofrinho.depositar(deposito2);

        System.out.print("Digite o valor que deseja retirar: R$ ");
        double retirada = entrada.nextDouble();
        cofrinho.retirar(retirada);

        System.out.println("\n--- RESUMO DO COFRINHO ---");
        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();

        entrada.close();
    }
}
