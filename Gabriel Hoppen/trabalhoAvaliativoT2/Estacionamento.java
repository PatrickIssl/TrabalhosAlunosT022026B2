import java.util.Scanner;

public class Estacionamento {

    private static Scanner scanner = new Scanner(System.in);

    private String placa;
    private String modelo;
    private double minutosEstacionado;
    private double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionado = 0;
        this.valorPago = 0;
    }

    public void adicionarTempo(double minutos) {
        if (minutos < 0) {
            System.out.println("Erro: o tempo não pode ser negativo.");
            return;
        }
        minutosEstacionado += minutos;
    }

    public double calcularValor() {
        double valor = 5.00;

        if (minutosEstacionado > 30) {
            valor += (minutosEstacionado - 30) * 0.10;
        }

        if (valor > 30.00) {
            valor = 30.00;
        }

        valorPago = valor;
        return valor;
    }

    public void exibirResumo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Minutos estacionado: " + minutosEstacionado);
        System.out.printf("Valor pago: R$ %.2f%n", valorPago);
    }

    public static void main(String[] args) {

        System.out.print("Digite a placa: ");
        String placa = scanner.nextLine();

        System.out.print("Digite o modelo: ");
        String modelo = scanner.nextLine();

        Estacionamento carro = new Estacionamento(placa, modelo);

        System.out.print("Digite os minutos estacionado: ");
        double minutos = scanner.nextDouble();
        carro.adicionarTempo(minutos);

        double valor = carro.calcularValor();
        System.out.printf("Valor calculado: R$%.2f%n", valor);

        carro.exibirResumo();
    }
}