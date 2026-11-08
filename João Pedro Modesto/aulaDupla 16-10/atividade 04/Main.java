public class Main {
    public static void main(String[] args) {
        Cofrinho joao = new Cofrinho("Joao",400);
        joao.depositar(100);
        joao.depositar(200);
        joao.retirar(400);
        joao.verificarMeta();
        joao.depositar(150);
        joao.verificarMeta();
        joao.retirar(400);
        joao.exibirSaldo();
    }
}
