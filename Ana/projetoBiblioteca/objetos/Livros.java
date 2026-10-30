package Ana.projetoBiblioteca.objetos;

public class Livros {

    private String titulo;
    private String autor;
    private String genero;
    private boolean disponivel;

    public Livros() {
    }

    public Livros(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = true;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String validarDisponibilidade() {
        String VERDE = "\u001B[32m";
        String VERMELHO = "\u001B[31m";
        String RESET = "\u001B[0m";
        if (disponivel) {
            return VERDE + "Disponível" + RESET;
        } else {
            return VERMELHO + "Indisponível" + RESET;
        }
    }
}
