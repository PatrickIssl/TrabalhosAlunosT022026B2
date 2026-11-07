public class Retangulo {
    private double largura;
    private double altura;

    public Retangulo() {
        setLargura(largura);
        setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return getLargura() * getAltura();
    }
    public double calcularPerimetro() {
        return 2 * (getLargura() + getAltura());
    }
}
