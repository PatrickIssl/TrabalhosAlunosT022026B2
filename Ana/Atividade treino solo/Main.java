
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {

	  Scanner scanner = new Scanner(System.in);

      System.out.println("Escolha uma opção:");
      System.out.println("1 - Estacionamento");
      System.out.println("2 - Refrigerante");
      System.out.println("3 - Campeonato");
      System.out.println("4 - Cofrinho");
      System.out.println("5 - Restaurante");
      
      int opcao = scanner.nextInt();
      
      if(opcao == 1) {
    	  
    	  Estacionamento carro = new Estacionamento("ABCD", "Fiesta");
    	  carro.adicionarTempo(31);
    	  carro.calcularValor();
    	  carro.exibirResumo();
    	  
      }else if(opcao == 2) {
            Refrigerante refrigerante = new Refrigerante();
            refrigerante.comprar();
            
        }else if(opcao == 3) {
     

    Campeonato timeA = new Campeonato("Time A", 1, 0, 0, 0);
    Campeonato timeB = new Campeonato("Time B", 0, 5, 0, 0);

    timeA.registrarVitoria();
    timeA.registrarVitoria();
    timeA.registrarEmpate();

    timeB.registrarVitoria();
    timeB.registrarEmpate();
    timeB.registrarDerrota();

    timeA.exibirEstatisticas();
    timeB.exibirEstatisticas();

    if (timeA.getPontos() > timeB.getPontos()) {
        System.out.println("Time A ganhou");
    } else if (timeB.getPontos() > timeA.getPontos()) {
        System.out.println("Time B ganhou");
    } else {
        System.out.println("Houve um empate ");
    }

}else if(opcao == 4) {
           Cofrinho cofrinho = new Cofrinho();
           cofrinho.setMeta(50.0);
           cofrinho.depositar(10.0);
           cofrinho.depositar(5.0);
           cofrinho.retirar(20.0);
           cofrinho.exibirSaldo();
           cofrinho.verificarMeta();
           
} else if (opcao == 5) {
            Pedido pedido = new Pedido();
            pedido.setNome("Ana");
            pedido.adicionarLanches(2);
            pedido.adicionarLanches(1);
            pedido.exibirPedido();
            pedido.calcularTotal();
            pedido.finalizarPedido();
            pedido.adicionarLanches(1);
            pedido.exibirPedido();
        }
   }
}

