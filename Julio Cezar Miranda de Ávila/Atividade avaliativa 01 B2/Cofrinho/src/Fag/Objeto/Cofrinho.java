package Fag.Objeto;

public class Cofrinho {
	private String dono;
	private double saldo, metaEconomia;
	
	public Cofrinho() {
	}
	
	public void setDono(String dono) {
		if (dono != null && !dono.isBlank()) {
			this.dono = dono;
		}
	}
	
	public void setMetaEconomia(Double metaEconomia) {
		if (metaEconomia > 0) {
			this.metaEconomia = metaEconomia;
		}
	}
	
	public void depositar(Double valor) {
		if (valor > 0) {
			saldo += valor;
		}
	}
	
	public void retirar(Double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
		}
		else {
			System.out.println("Valor invalido!");
		}
	}
	
	public void exibirSaldo() {
		System.out.println("Saldo: R$" + saldo);
	}
	
	public void verificarMeta() {
		System.out.println("Meta economica: R$" + metaEconomia);
		exibirSaldo();
		if (saldo >= metaEconomia) {
			System.out.println("Meta economica atingida!");
		}
		else {
			System.out.println("Meta economica ainda não atingida!");
			System.out.println("Quantia para bater a meta economica: R$" + (metaEconomia - saldo));
		}
	}
	
	public void menu() {
		System.out.printf("\n--- Menu ---\n");
		System.out.println("1 - Alterar dono");
		System.out.println("2 - Alterar meta economica");
		System.out.println("3 - Depositar");
		System.out.println("4 - Retirar");
		System.out.println("5 - Exibir saldo");
		System.out.println("6 - Verificar meta");
		System.out.println("0 - Sair");
		System.out.printf("\nEntre com o numero da opção desejada:\n");
		
	}
}
