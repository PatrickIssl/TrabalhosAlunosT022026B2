package objetos;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private List<Livro> LivrosLocados;

    public Pessoa() {
        this.LivrosLocados = new ArrayList<Livro>();
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.LivrosLocados = new ArrayList<Livro>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivrosLocados() {
        return LivrosLocados;
    }

    public void setLivrosLocados(List<Livro> livrosLocados) {
        LivrosLocados = livrosLocados;
    }
}