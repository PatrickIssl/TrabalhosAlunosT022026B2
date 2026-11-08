public class Pedido {
    private String nomeCliente;
    private int qtdLanches;
    private double precoLanche = 18;
    private int taxaEntrega = 7;
    private boolean status = true;
    
    public Pedido(String nome){
        setNome(nome);
    }

    public void setNome(String nome){
        this.nomeCliente = nome;
    }

    public void adicionarLanches(int quant){
        if (status == true) {
            if (quant > 0){
                qtdLanches+=quant;
                System.out.println(quant+" lanches adicionados.");
            }
            else {
                System.out.println("Quantidade invalida");
                }
        }
        else {
            System.out.println("Pedido já finalizado.");
        }   
    }

    public void calcularTotal(){
        double total = qtdLanches*precoLanche;
        if (status == true){
            if (qtdLanches >= 3){
                total = (total -(total*0.1))+taxaEntrega;
                System.out.println("Total: "+total);
            }
            else {
                total = total + taxaEntrega;
                System.out.println("Total: "+total);
            }
        }
       
    }

    public void finalizarPedido(){
        if (status == true){
            status = false;
            System.out.println("Pedido finalizado com sucesso.");
        }
        else {
            System.out.println("Pedido ja finalizado.");
        }
    }

    public void exibirPedido(double total){
        System.out.println("Cliente: "+nomeCliente);
        System.out.println("Quantidade: "+qtdLanches);
        if (status == true){
            System.out.println("Pedido ainda em aberto");
        }
        else {
            System.out.println("Pedido ja finalizado");
        }
        calcularTotal();
    }

}
