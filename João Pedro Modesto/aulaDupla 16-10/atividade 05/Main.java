public class Main {
    public static void main(String[] args) {
        Pedido lanche = new Pedido("Joao");
        lanche.adicionarLanches(1);
        lanche.adicionarLanches(2);
        lanche.calcularTotal();
        lanche.finalizarPedido();
        lanche.adicionarLanches(1);
        lanche.exibirPedido(0);
        
    }
    
}
