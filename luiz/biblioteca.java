package fag;

public class biblioteca {
	
	private String titulo;
	private String genero;
	private int quantidadepaginas;
	private boolean locacao;
	
	public biblioteca() 
	{
	}
	public biblioteca(String titulo, String genero, int quantidadepaginas) {
		
		this.titulo = titulo;
		this.genero = genero;
		this.quantidadepaginas = quantidadepaginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getQuantidadepaginas() {
		return quantidadepaginas;
	}
	public void setQuantidadepaginas(int quantidadepaginas) {
		this.quantidadepaginas = quantidadepaginas;
	}
	public boolean isLocacao() {
		return locacao;
	}
	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}

	
	
	public String validarlocacao() 
	{
		if(locacao == false) 
		{
			return "disponivel";
		}
		else 
		{
			return "nao esta disponivel";
		}
	}
}
