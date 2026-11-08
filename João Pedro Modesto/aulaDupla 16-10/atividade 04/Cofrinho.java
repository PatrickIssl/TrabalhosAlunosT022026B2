public class Cofrinho {
    
    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho (String dono, double meta){
        setDono(dono);
        setMeta(meta);
    }

    public void setDono(String dono){
        if (dono != null && !dono.isBlank()){
            this.dono = dono;
        }
    }
    
    public void setMeta(Double meta){
        if (meta > 0){
            this.metaEconomia = meta;
        }
    }

    public void depositar (double valor){
        if (valor > 0){
            saldo+=valor;
            System.out.println(valor+" reais depositados com sucesso.");
        }
        else {
            System.out.println("Valor inválido.");
        }
    }

    public void retirar(double valor){
        if (saldo >= valor && valor > 0){
            saldo-=valor;
            System.out.println(valor+" reais retirados com sucesso");
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void verificarMeta(){
        if (saldo >= metaEconomia){
            System.out.println("Parabéns, você atingiu a meta.");
        }
        else {
            double diferença = metaEconomia-saldo;
            System.out.println("Faltam "+diferença+" reais para a meta");
        }
    }

    public void exibirSaldo(){
        System.out.println("Saldo: "+saldo);
    }


}
