
public class cofrinho {
    private String dono;
    private double saldo;
    private double metaEconomia;

    // Gere os getters e setters pelo Eclipse

    public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getMetaEconomia() {
		return metaEconomia;
	}

	public void setMetaEconomia(double metaEconomia) {
		this.metaEconomia = metaEconomia;
	}

	public void depositar(double valor) {
        if (valor > 0)
            saldo += valor;
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo)
            saldo -= valor;
        else
            System.out.println("Saldo insuficiente!");
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia)
            System.out.println("Meta atingida!");
        else
            System.out.println("Faltam R$ " + (metaEconomia - saldo));
    }

    public void exibirSaldo() {
        System.out.println(dono);
        System.out.println("Saldo: R$ " + saldo);
    }
}