
public class Principal {
    public static void main(String[] args) {

        
        Estacionamento carro = new Estacionamento();

        carro.setPlaca("ABC1234");
        carro.setModelo("Civic");
        carro.adicionarTempo(60);

        System.out.println("--- ESTACIONAMENTO ---");
        carro.exibirResumo();


    
        Refrigerante maquina = new Refrigerante();
        maquina.reporEstoque(5);
        maquina.comprar(2, 10.00);
        maquina.comprar(4, 20.00);
        maquina.exibirEstado();
    
        campeonato t1 = new campeonato();
        t1.setNome("Time A");
        t1.registrarVitoria();
        t1.registrarVitoria();

        campeonato t2 = new campeonato();
        t2.setNome("Time B");
        t2.registrarVitoria();
        t2.registrarEmpate();

        t1.exibirEstatisticas();
        t2.exibirEstatisticas();

        if (t1.getPontos() > t2.getPontos())
            System.out.println("Time A tem mais pontos");
        else if (t2.getPontos() > t1.getPontos())
            System.out.println("Time B tem mais pontos");
        else
            System.out.println("Os dois times tem os mesmos pontos");
    
        cofrinho c = new cofrinho();
        c.setDono("Carol");
        c.setMetaEconomia(500);

        c.depositar(200);
        c.depositar(100);
        c.retirar(400);

        c.exibirSaldo();
        c.verificarMeta();
    
        Pedido p = new Pedido();
        p.setNomeCliente("Carol");

        p.adicionarLanches(2);
        p.adicionarLanches(1);

        p.exibirPedido();
        p.finalizarPedido();

        p.adicionarLanches(1);
        p.exibirPedido();
    }
    
    
    
    
}