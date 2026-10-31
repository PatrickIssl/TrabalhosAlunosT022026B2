public class ProgramaPedido {

    public static void main(String[] args) {

        Pedido p = new Pedido("Joao");

        // adicionando lanches em duas vezes
        p.adicionarLanches(2);
        p.adicionarLanches(1);

        System.out.println("Total do pedido: R$ " + p.calcularTotal());

        p.finalizarPedido();
        p.exibirPedido();

        // tentando adicionar depois de finalizar
        boolean conseguiu = p.adicionarLanches(1);

        if (conseguiu) {
            System.out.println("Lanche adicionado com sucesso.");
        } else {
            System.out.println("Nao foi possivel adicionar, o pedido ja foi finalizado.");
        }
    }
}
