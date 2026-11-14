package Fag.Objeto;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {

    private String nome;
    private List<Time> livrosEmprestados;

    public Campeonato() {
        this.livrosEmprestados = new ArrayList<Time>();
    }

    public Campeonato(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<Time>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Time> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<Time> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }
}