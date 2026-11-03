
public class Estacionamento {
    String placa;
    String modelo;
    int minutosEstacionado;
    double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionado = 0;
        this.valorPago = 0;
    }

    public void adicionarTempo(int minutos) {
        if (minutos >= 0) {
            minutosEstacionado += minutos;
        } else {
            System.out.println("O tempo não pode ser negativo!");
        }
    }

    public void calcularValor() {
        if (minutosEstacionado <= 30) {
            valorPago = 5.00;
        } else {
            valorPago = 5.00 + (minutosEstacionado - 30) * 0.10;
        }

        if (valorPago > 30.00) {
            valorPago = 30.00;
        }
    }

    public void exibirResumo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Minutos estacionado: " + minutosEstacionado);
        System.out.printf("Valor a pagar: R$ %.2f%n", valorPago);
    }
}
