class Aluno {
    private String nome;
    private int id;
    private Double nota;

    public Aluno(String nome, int id, Double nota) {
        this.nome = nome;
        this.id = id;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public Double getNota() {
        return nota;
    }

    public String validarNota() {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        if (nota < 7) {
            return vermelho + "Reprovado" + reset;
        } else {
            return verde + "Aprovado" + reset;
        }
    }
}