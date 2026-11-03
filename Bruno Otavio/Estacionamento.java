package Principal;

import java.util.Scanner;

public class Estacionamento {

    private static final Scanner scanner = new Scanner(System.in);

    private String placa;
    private String modelo;
    private int minutosEstacionado = 0;
    private double valorPago = 0;

    public void carro() {

        System.out.println("Qual o modelo do seu carro?");
        modelo = scanner.nextLine();

        System.out.println("Qual a placa do seu carro?");
        placa = scanner.nextLine();

        System.out.println("Seu modelo é " + modelo
                + "\nE sua placa é " + placa + "!");
    }

    public void adicionarTempo() {

        System.out.print("Digite quanto tempo ficou em minutos: ");
        int minutos = scanner.nextInt();

        if (minutos < 0) {
            System.out.println("O tempo não pode ser negativo.");
        } else {
            minutosEstacionado += minutos;

            System.out.println("Você ficou estacionado por "
                    + minutosEstacionado + " minutos!");
        }
    }

    public void calcularValor() {

        if (minutosEstacionado <= 0) {
            valorPago = 0;
        } else if (minutosEstacionado <= 30) {
            valorPago = 5.0;
        } else {
            valorPago = 5.0 + (minutosEstacionado - 30) * 0.10;
        }

        if (valorPago > 30.0) {
            valorPago = 30.0;
        }

        System.out.printf("Valor a pagar: R$ %.2f%n", valorPago);
    }

    public void exibirResumo() {

        System.out.println("\n RESUMO DO ESTACIONAMENTO ");
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Minutos estacionado: " + minutosEstacionado);
        System.out.printf("Valor pago: R$ %.2f%n", valorPago);
    }

    public static void main(String[] args) {

        Estacionamento estacionamento = new Estacionamento();

        estacionamento.carro();
        estacionamento.adicionarTempo();
        estacionamento.calcularValor();
        estacionamento.exibirResumo();

        scanner.close();
    }
}