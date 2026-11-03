package objeto;

public class Cofrinho {
	private String dono;
	private double saldo;
	private double metaEconomia;
	public Cofrinho () {
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		if (dono!=null && !dono.isBlank()) {
			this.dono = dono;
		}else {
			System.out.println("O nome não pode estar vazio!");
		}
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		if(saldo >= 0) {
			this.saldo = saldo;
		}else {
			System.out.println("O valor não pode ser negativo");
		}
	}
	public double getMetaEconomia() {
		return metaEconomia;
	}
	public void setMetaEconomia(double metaEconomia) {
		if(metaEconomia > 0 ){
			this.metaEconomia = metaEconomia;
		}else {
			System.out.println("A meta não pode ser 0 ou um valor negativo:");
		}
	}
	public void depositar(double valor) {
		if (this.metaEconomia != this.saldo) {
			if (valor  >0 ) {
				this.saldo+=valor;
				double meta =  getMetaEconomia() - getSaldo();
				System.out.println("Valor para atingir a meta: " +meta);  
			}else {
				System.out.println("O valor não pode ser negativo");
			}
		}else {
			System.out.println("Parabens você atingiu a meta");
		}
	}
	public void retirar(double valor) {
		if (valor  > 0 && valor<=this.saldo ) {
			this.saldo-=valor;
			double meta =  getMetaEconomia() - getSaldo();
			System.out.println("Valor para atingir a meta: " +meta);  
		}else {
			System.out.println("O valor não pode ser zero ou negativo e nem maior que o saldo atual");
		}
	}
	public void verificarMeta() {
		double meta =  getMetaEconomia() - getSaldo();
		System.out.println("Meta do cofre do "+getDono()+": "+getMetaEconomia()+" Valor para atingir: "+meta);
	}
	public void exibirSaldo(){
		System.out.println("saldo do cofre do "+getDono()+": "+getSaldo());
	}
}
