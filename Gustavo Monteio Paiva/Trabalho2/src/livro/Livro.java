package livro;

import usuario.Usuario;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private Usuario emprestadoPara; 

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Usuario getEmprestadoPara() { return emprestadoPara; }

    public boolean estaDisponivel() {
        return emprestadoPara == null;
    }

    public void emprestar(Usuario usuario) {
        this.emprestadoPara = usuario;
    }

    public void devolver() {
        this.emprestadoPara = null;
    }
}
