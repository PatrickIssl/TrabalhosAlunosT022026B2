public class Retangulo {
    private final double largura;
    private final double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public void exibirInformacoes() {
        System.out.printf("Área: %.2f%n", largura * altura);
        System.out.printf("Perímetro: %.2f%n", 2 * (largura + altura));
    }
}
