public class Estacionamento {

    private String placa;
    private String modelo;
    private int minutosEstacionados;
    private double valorPago;

    public Estacionamento(String placa, String modelo, int minutos){
    setPlaca(placa);
    setModelo(modelo);
    setMin(minutos);
    }


    public void setPlaca(String placa){
        if (placa != null && !placa.isBlank()){
            this.placa = placa;
        }
    }

    public void setModelo(String modelo){
        if (modelo != null && !modelo.isBlank()){
            this.modelo = modelo;
        }
    }

    public void setMin(int minutos){
        if (minutos > 0){
            this.minutosEstacionados = minutos;
        }
    }



    public void adicionarTempo(int minutos){
        if (minutos > 0)
        minutosEstacionados+=minutos;
    }

    public void calcValor(){
        if (minutosEstacionados <= 30){
            valorPago =  5;
        }
        if ((minutosEstacionados*0.10)+5 >= 30){
        valorPago = 30;
        }
        else {
            valorPago = (minutosEstacionados*0.10)+2;
        }
    }

    public void exibirResumo(){
        System.out.println("Placa: " + placa );
        System.out.println("Modelo: "+modelo);
        System.out.println("Minutos estacionados: "+minutosEstacionados);
        System.out.println("Valor pago: "+valorPago);
    }

}