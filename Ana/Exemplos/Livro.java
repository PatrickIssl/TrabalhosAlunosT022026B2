public class Livro {
    private final String titulo;
    private final String autor;
    private final int paginas;
    private boolean emprestado;

    public Livro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + paginas);
        System.out.println("Disponível: " + (emprestado ? "Não" : "Sim"));
    }

    public void emprestar() {
        if (emprestado) {
            System.out.println("O livro já está emprestado.");
            return;
        }
        emprestado = true;
        System.out.println("Livro emprestado com sucesso.");
    }

    public void devolver() {
        if (!emprestado) {
            System.out.println("O livro não está emprestado.");
            return;
        }
        emprestado = false;
        System.out.println("Livro devolvido com sucesso.");
    }
}
