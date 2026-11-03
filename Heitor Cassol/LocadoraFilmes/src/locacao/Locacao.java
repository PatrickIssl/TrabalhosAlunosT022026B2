
package locacao;

public class Locacao {

    public void alugar(Filmes filme, Cliente cliente) {

        if (cliente.filmeAlugado != null) {
            System.out.println("Você já possui um filme alugado!");
        } 
        else if (filme.disponivel) {
            filme.disponivel = false;
            cliente.filmeAlugado = filme;

            System.out.println("Filme alugado para: " + cliente.getNome());
            System.out.println("Filme: " + filme.nome);
        } 
        else {
            System.out.println("Filme indisponível!");
        }
    }

    public void devolver(Cliente cliente) {

        if (cliente.filmeAlugado != null) {

            System.out.println("Filme devolvido: " + cliente.filmeAlugado.nome);

            cliente.filmeAlugado.disponivel = true;
            cliente.filmeAlugado = null;

            System.out.println("Devolução realizada com sucesso!");

        } 
        else {
            System.out.println("Você não possui nenhum filme alugado!");
        }
    }
}
