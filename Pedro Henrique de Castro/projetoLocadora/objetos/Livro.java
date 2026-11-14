package objetos;

import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private Date dataLocacao;

    public Livro() {
    }

    public Livro(String titulo, String autor, Date dataLocacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataLocacao = dataLocacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public String validarDisponibilidade() {
        String VERDE = "\u001B[32m";
	    String VERMELHO = "\u001B[31m";
	    String RESET = "\u001B[0m";
		if(dataLocacao == null) {
			return VERDE+"Disponivel"+RESET;
		}else {
			return VERMELHO+"Indisponivel"+RESET;
		}
    }
}