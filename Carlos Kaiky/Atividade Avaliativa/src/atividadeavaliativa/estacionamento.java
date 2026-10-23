package atividadeavaliativa;
public class estacionamento {
    String placa;
    String modelo;
    int minutos;
    double total;

    public estacionamento(String pPlaca, String pModelo) {
        placa = pPlaca;
        modelo = pModelo;
        minutos = 0;
        total = 0.0;
    }
    public void adicionarTempo(int tempo) {
        if (tempo > 0) {
            minutos = minutos + tempo;
        }else {
        	System.out.println("tempo invalido");
        }
    }
    public void calcularValor() {
        if (minutos <= 30) {
            total = 5.0; 
        } else {
            total = 5.0 + ((minutos - 30) * 0.1);
        }
        if (total > 30.0) {
            total = 30.0;
        }
    }
    public void exibirResumo() {
        calcularValor(); 
        
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tempo: " + minutos + " minutos");
        System.out.println("Valor: " + total + " reais");
    }
    public static void main(String[] args) {
        
        estacionamento carro = new estacionamento("kfc3j43", "Celta");
        
        carro.adicionarTempo(45);
        carro.exibirResumo();
        
    }
}