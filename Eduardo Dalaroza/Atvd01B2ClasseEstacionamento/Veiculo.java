package Atvd01B2ClasseEstacionamento;
public class Veiculo{

    String modelo;
    String placa;
    int minutosEstacionado;
    double valorPago;

    void adicionarTempo(int minutos) {
        if(minutos >= 0){
            minutosEstacionado += minutos;
        }
    }


    void calcularValor(){
        if(minutosEstacionado <= 30){
            valorPago = 5.0;
        }else{
            valorPago = 5.0 + (minutosEstacionado - 30) * 0.10;
        }
        if(valorPago > 30){
            valorPago = 30.0;
        }
    }

    void exibirResumo(){
        System.out.println("-----------INFORMAÇÔES-----------");
        System.out.println("MODELO:  " + modelo);
        System.out.println("PLACA: " + placa);
        System.out.println("Você ficou  " + minutosEstacionado + " minutos estacionados.");
        System.out.printf("O valor pago foi de: R$ %.2f%n ", valorPago);
    }
}



