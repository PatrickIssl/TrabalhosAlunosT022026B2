
package Objetos;

public class Jogo {

    private String nome;
    private String genero;

    public Jogo(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void set(String novonome, String novogenero) {
        this.nome = novonome;
        this.genero = novogenero;
    }
}
