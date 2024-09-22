package sistema;

import livro.Livro;
import usuario.Usuario;

import java.util.Scanner;

public class SistemaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Adicionando alguns livros e usuários iniciais
        sistema.adicionarLivro(new Livro("Java: Como Programar", "Deitel", 2018));
        sistema.adicionarLivro(new Livro("Clean Code", "Robert C. Martin", 2008));
        sistema.adicionarUsuario(new Usuario("Carlos Silva", "12345", "Professor"));
        sistema.adicionarUsuario(new Usuario("Maria Souza", "67890", "Aluno"));

        // Menu de interação com o sistema
        int opcao;
        do {
            System.out.println("\n--- Sistema de Empréstimo de Livros ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Usuário");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    sistema.adicionarLivro(new Livro(titulo, autor, ano));
                    break;

                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Digite o tipo (Professor ou Aluno): ");
                    String tipo = scanner.nextLine();
                    sistema.adicionarUsuario(new Usuario(nome, matricula, tipo));
                    break;

                case 3:
                    sistema.listarLivrosDisponiveis();  // Listar livros disponíveis antes do empréstimo
                    System.out.print("Digite o título do livro para empréstimo: ");
                    String tituloEmprestimo = scanner.nextLine();
                    System.out.print("Digite a matrícula do usuário: ");
                    String matriculaEmprestimo = scanner.nextLine();
                    sistema.realizarEmprestimo(tituloEmprestimo, matriculaEmprestimo);
                    break;

                case 4:
                    sistema.listarLivrosEmprestados();  // Listar livros emprestados antes da devolução
                    System.out.print("Digite o título do livro para devolução: ");
                    String tituloDevolucao = scanner.nextLine();
                    System.out.print("Digite a matrícula do usuário: ");
                    String matriculaDevolucao = scanner.nextLine();
                    sistema.devolverLivro(tituloDevolucao, matriculaDevolucao);
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
