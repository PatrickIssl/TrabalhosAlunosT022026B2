
package Avaliativa3.objeto;

public class Funcionario {

    private int id;
    private String nome;
    private String cargo;
    private String email;
    private double salario;

    public Funcionario(){
    }

    public Funcionario(int id, String nome, String cargo, String email, double salario){
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.salario = salario;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

}
