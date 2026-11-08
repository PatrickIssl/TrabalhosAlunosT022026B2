public class Main{
    public static void main(String[] args) {
        

    MaquinaRefrigerante refri = new MaquinaRefrigerante();
    refri.reporEstoque(10);
    refri.exibirEstado();
    refri.Comprar(2, 9);
    refri.exibirEstado();
    refri.Comprar(3, 10);




    }

}