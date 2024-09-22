package sistema;

import livro.Livro;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    // Construtor
    public SistemaBiblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Método para adicionar livros
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro '" + livro.getTitulo() + "' adicionado à biblioteca.");
    }

    // Método para adicionar usuários
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário '" + usuario.getNome() + "' adicionado ao sistema.");
    }

    // Método para realizar empréstimo
    public void realizarEmprestimo(String tituloLivro, String matriculaUsuario) {
        Livro livro = buscarLivro(tituloLivro);
        Usuario usuario = buscarUsuario(matriculaUsuario);

        if (livro != null && usuario != null) {
            if (livro.isDisponivel()) {
                livro.setDisponivel(false);
                int prazoDevolucao = calcularPrazoDevolucao(usuario);
                System.out.println("Empréstimo realizado para " + usuario.getNome() + ".");
                System.out.println("Prazo de devolução: " + prazoDevolucao + " dias.");
            } else {
                System.out.println("O livro '" + livro.getTitulo() + "' não está disponível.");
            }
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    // Método para devolver livro
    public void devolverLivro(String tituloLivro, String matriculaUsuario) {
        Livro livro = buscarLivro(tituloLivro);
        Usuario usuario = buscarUsuario(matriculaUsuario);

        if (livro != null && usuario != null) {
            if (!livro.isDisponivel()) {
                livro.setDisponivel(true);
                System.out.println("Livro '" + livro.getTitulo() + "' devolvido por " + usuario.getNome() + ".");
            } else {
                System.out.println("Este livro não foi emprestado.");
            }
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    // Método para listar livros disponíveis para empréstimo
    public void listarLivrosDisponiveis() {
        System.out.println("\n--- Livros Disponíveis para Empréstimo ---");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livro.mostrarDetalhes();
            }
        }
    }

    // Método para listar livros emprestados (não disponíveis) para devolução
    public void listarLivrosEmprestados() {
        System.out.println("\n--- Livros Emprestados para Devolução ---");
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                livro.mostrarDetalhes();
            }
        }
    }

    // Método para buscar livro
    private Livro buscarLivro(String tituloLivro) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                return livro;
            }
        }
        return null;
    }

    // Método para buscar usuário
    private Usuario buscarUsuario(String matriculaUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equalsIgnoreCase(matriculaUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para calcular prazo de devolução
    private int calcularPrazoDevolucao(Usuario usuario) {
        if (usuario.getTipo().equalsIgnoreCase("Professor")) {
            return 30; // 30 dias para professores
        } else if (usuario.getTipo().equalsIgnoreCase("Aluno")) {
            return 15; // 15 dias para alunos
        } else {
            return 0;
        }
    }
}
