
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a quantidade inicial de refrigerantes: ");
        int estoque = entrada.nextInt();

        MaquinaRefrigerante maquina =
                new MaquinaRefrigerante(estoque);

        for (int i = 1; i <= 2; i++) {
            System.out.println("\n--- COMPRA " + i + " ---");

            System.out.print("Quantidade desejada: ");
            int quantidade = entrada.nextInt();

            System.out.print("Valor pago: R$ ");
            double valorPago = entrada.nextDouble();

            maquina.comprar(quantidade, valorPago);
        }

        maquina.exibirEstado();

        entrada.close();
    }
}
