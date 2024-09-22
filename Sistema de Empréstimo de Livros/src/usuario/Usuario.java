package usuario;

public class Usuario {
    private String nome;
    private String matricula;
    private String tipo; // "Professor" ou "Aluno"

    // Construtor
    public Usuario(String nome, String matricula, String tipo) {
        this.nome = nome;
        this.matricula = matricula;
        this.tipo = tipo;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    // Método para mostrar detalhes do usuário
    public void mostrarDetalhes() {
        System.out.println("Nome: " + nome + ", Matrícula: " + matricula + ", Tipo: " + tipo);
    }
}
