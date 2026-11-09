package exercicio04;

public class Main {

	public static void main(String[] args) {
		Cofrinho c = new Cofrinho("Mateus Kaiky Mezzomo", 300);
		
		c.depositar(350);
		c.retirar(30000);
		c.exibirSaldo();
		c.verificarMeta();
		c.retirar(200);
		c.exibirSaldo();
		c.verificarMeta();
	}

}
