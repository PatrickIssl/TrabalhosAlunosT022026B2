
package locacao;

public class Cliente {

    String nome;
    int codigo;
    Filmes filmeAlugado;

    public Cliente(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.filmeAlugado = null;
    }

    public String getNome() {
        return nome;
    }
}
