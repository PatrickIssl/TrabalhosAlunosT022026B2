package cadastro;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoP;
    private int qntPag;
    private double valor;

    public Livro(int id, String titulo, String autor, String isbn, int anoP, int qntPag, double valor) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoP = anoP;
        this.qntPag = qntPag;
        this.valor = valor;
    }

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public int getAnoP() {
		return anoP;
	}



	public void setAnoP(int anoP) {
		this.anoP = anoP;
	}



	public int getQntPag() {
		return qntPag;
	}



	public void setQntPag(int qntPag) {
		this.qntPag = qntPag;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public void exibirDados() {
        System.out.println("------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Ano de publicação: " + anoP);
        System.out.println("Quantidade de páginas: " + qntPag);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("------------------------------");
    }
}
