public class Celular {
    private final String marca;
    private final String modelo;
    private int bateria;

    public Celular(String marca, String modelo, int bateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = Math.max(0, Math.min(100, bateria));
    }

    public void usarCelular() {
        if (bateria == 0) {
            System.out.println("A bateria está descarregada.");
            return;
        }
        bateria = Math.max(0, bateria - 10);
        System.out.println("Celular em uso.");
    }

    public void carregar() {
        bateria = Math.min(100, bateria + 10);
        System.out.println("Celular carregado.");
    }

    public void exibirBateria() {
        System.out.println("Celular: " + marca + " " + modelo);
        System.out.println("Bateria: " + bateria + "%");
    }
}
