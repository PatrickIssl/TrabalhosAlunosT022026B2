package atividadeavaliativa;

public class Pedido {
	  
    String nomeCliente;
   int quantidadeLanches;
   double precoLanche;
   double taxaEntrega;
   String status;

   public Pedido(String nome) {
       nomeCliente = nome;
       quantidadeLanches = 0;
       precoLanche = 18.00;
       taxaEntrega = 7.00;
       status = "Em andamento";
   }

   public void adicionarLanches(int quantidade) {
       if (status.equals("Finalizado")) {
           System.out.println("Operação não permitida: o pedido já foi finalizado.");
       } else {
           quantidadeLanches = quantidadeLanches + quantidade;
           System.out.println(quantidade + " lanche(s) adicionado(s) ao pedido.");
       }
   }

   public double calcularTotal() {
       double totalLanches = quantidadeLanches * precoLanche;

       if (quantidadeLanches >= 3) {
           totalLanches = totalLanches - (totalLanches * 0.10);
       }

       double total = totalLanches + taxaEntrega;
       return total;
   }

   public void finalizarPedido() {
       status = "Finalizado";
       System.out.println("Pedido finalizado com sucesso!");
   }

   public void exibirPedido() {
       System.out.println("----- Dados do Pedido -----");
       System.out.println("Cliente: " + nomeCliente);
       System.out.println("Quantidade de lanches: " + quantidadeLanches);
       System.out.println("Status: " + status);
       System.out.println("Total do pedido: " + calcularTotal());
       System.out.println("----------------------------");
   }

   public static void main(String[] args) {
       Pedido pedido1 = new Pedido("Maria");

       pedido1.adicionarLanches(2);
       pedido1.adicionarLanches(1);

       pedido1.finalizarPedido();

       pedido1.exibirPedido();

       pedido1.adicionarLanches(1);
   }
}
