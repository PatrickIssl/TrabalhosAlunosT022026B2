package Atvd02B2ClasseMaquinaRefrigerantes;

public class TesteMaquina {

    public static void main(String[] args) {

        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        maquina.reporEstoque(10);
        maquina.exibirEstado();

        System.out.println("\nCOMPRA 1: 2 refrigerantes pagando R$ 10,00");
        maquina.comprar(2, 10.00);

        System.out.println("\nCOMPRA 2: 3 refrigerantes pagando R$ 10,00");
        maquina.comprar(3, 10.00);

        System.out.println("\nESTADO FINAL");
        maquina.exibirEstado();
    }
}
