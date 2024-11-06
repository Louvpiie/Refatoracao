import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Projeto> projetos = new ArrayList<Projeto>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: 
                    criarProjeto(projetos, scanner);
                    break;
                case 2: 
                    adicionarResponsavel(projetos, scanner);
                    break;
                case 3: 
                    removerResponsavel(projetos, scanner);
                    break;
                case 4: 
                    listarProjetos(projetos);
                    break;
                case 5: 
                    excluirProjeto(projetos, scanner);
                    break;
                case 6: 
                    System.out.println("Saindo do programa...");
                    break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nGERENCIAMENTO DE FUNCIONARIOS E PROJETOS:");
        System.out.println("1. Criar novo projeto");
        System.out.println("2. Adicionar Responsável a um projeto");
        System.out.println("3. Remover Responsável de um projeto");
        System.out.println("4. Listar projetos");
        System.out.println("5. Excluir projeto");
        System.out.println("6. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static void criarProjeto(List<Projeto> projetos, Scanner scanner) {
        System.out.print("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Digite o prazo do projeto (AAAA-MM-DD): ");
        LocalDate prazoProjeto = LocalDate.parse(scanner.nextLine());

        Projeto projeto = new Projeto(nomeProjeto, prazoProjeto);
        if (!projeto.prazoValido()) {
            System.out.println("Data de prazo inválida. O prazo deve ser uma data futura.");
            return;
        }

        System.out.print("Digite o nome do responsável: ");
        String nomeResponsavel = scanner.nextLine();
        System.out.print("Digite o cargo do responsável: ");
        String cargoResponsavel = scanner.nextLine();
        System.out.print("Digite o salário do responsável: ");
        double salarioResponsavel = scanner.nextDouble();
        scanner.nextLine();

        projeto.setResponsavel(new Funcionario(nomeResponsavel, cargoResponsavel, salarioResponsavel));
        projetos.add(projeto);
        System.out.println("Projeto criado com sucesso!");
    }

    private static void adicionarResponsavel(List<Projeto> projetos, Scanner scanner) {
        if (projetos.isEmpty()) {
            System.out.println("Não existem projetos cadastrados.");
            return;
        }

        listarProjetos(projetos);
        System.out.print("Digite o número do projeto para adicionar o funcionário: ");
        int numeroProjeto = scanner.nextInt();
        scanner.nextLine();

        if (numeroProjeto >= 1 && numeroProjeto <= projetos.size()) {
            Projeto projeto = projetos.get(numeroProjeto - 1);
            System.out.print("Digite o nome do funcionário: ");
            String nomeFuncionario = scanner.nextLine();
            System.out.print("Digite o cargo do funcionário: ");
            String cargoFuncionario = scanner.nextLine();
            System.out.print("Digite o salário do funcionário: ");
            double salarioFuncionario = scanner.nextDouble();
            scanner.nextLine();

            projeto.setResponsavel(new Funcionario(nomeFuncionario, cargoFuncionario, salarioFuncionario));
            System.out.println("Funcionário adicionado ao projeto com sucesso!");
        } else {
            System.out.println("Número de projeto inválido.");
        }
    }

    private static void removerResponsavel(List<Projeto> projetos, Scanner scanner) {
        if (projetos.isEmpty()) {
            System.out.println("Não existem projetos cadastrados.");
            return;
        }

        listarProjetos(projetos);
        System.out.print("Digite o número do projeto para remover o funcionário: ");
        int numeroProjeto = scanner.nextInt();
        scanner.nextLine();

        if (numeroProjeto >= 1 && numeroProjeto <= projetos.size()) {
            projetos.get(numeroProjeto - 1).removeResponsavel();
            System.out.println("Funcionário removido do projeto com sucesso!");
        } else {
            System.out.println("Número de projeto inválido.");
        }
    }

    private static void listarProjetos(List<Projeto> projetos) {
        if (projetos.isEmpty()) {
            System.out.println("Não existem projetos cadastrados.\n");
            return;
        }

        System.out.println("\nProjetos cadastrados:");
        for (int i = 0; i < projetos.size(); i++) {
            Projeto projeto = projetos.get(i);
            System.out.println((i + 1) + ". " + projeto.getNome() + " - Prazo: " + projeto.getPrazo());
            if (projeto.getResponsavel() != null) {
                System.out.println("   Responsável: " + projeto.getResponsavel().getNome() + " (" + projeto.getResponsavel().getCargo() + ")");
            }
        }
    }

    private static void excluirProjeto(List<Projeto> projetos, Scanner scanner) {
        if (projetos.isEmpty()) {
            System.out.println("Não existem projetos criados.\n");
            return;
        }
        listarProjetos(projetos);
        System.out.print("Digite o nome do projeto que deseja excluir: ");
        String nomeProjeto = scanner.nextLine(); // Lê o nome como string
        for (int i = 0; i < projetos.size(); i++) {
            if (projetos.get(i).getNome().equals(nomeProjeto)) { // Compara com o nome do projeto
                projetos.remove(i);
                System.out.println("Projeto excluído com sucesso.");
                return; // Sai da função após excluir o projeto
            }
        }
        System.out.println("Projeto não encontrado.");
    }

}