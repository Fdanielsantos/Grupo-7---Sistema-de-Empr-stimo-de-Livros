package livro;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

    // Construtor
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;  // Livro está disponível ao ser adicionado
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Método para mostrar detalhes do livro
    public void mostrarDetalhes() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }
}