public class App {
    public static void main(String[] args) {
        Estacionamento veiculo = new Estacionamento("ABC-1234", "Civic");

        veiculo.adicionarTempo(60);
        veiculo.calcularValor();
        veiculo.exibirResumo();
    }
}   