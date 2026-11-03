public class Funcionario {
    private final String nome;
    private final String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.printf("Salário: R$ %.2f%n", salario);
    }

    public void aumentarSalario(double percentual) {
        if (percentual < 0) {
            System.out.println("O percentual não pode ser negativo.");
            return;
        }
        salario += salario * percentual / 100;
    }
}
