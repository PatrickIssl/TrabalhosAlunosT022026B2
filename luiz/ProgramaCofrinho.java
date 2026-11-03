public class ProgramaCofrinho {

    public static void main(String[] args) {

        Cofrinho cofrinho = new Cofrinho("Maria", 500);

        cofrinho.depositar(200);
        cofrinho.depositar(150);
        cofrinho.depositar(-50); // teste de valor invalido

        cofrinho.exibirSaldo();

        // Tentativa de retirada acima do saldo
        cofrinho.retirar(1000);

        cofrinho.exibirSaldo();

        // Verificacao final da meta
        cofrinho.verificarMeta();
    }
}
