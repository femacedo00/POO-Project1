package br.com.gestao_escolar;

import java.util.*;
import br.com.gestao_escolar.model.*;
import br.com.gestao_escolar.controller.Comando;
import br.com.gestao_escolar.controller.Repositorio;
import br.com.gestao_escolar.controller.service.RepositorioFactory;
import br.com.gestao_escolar.controller.CadastrarAlunoCommand;
import br.com.gestao_escolar.controller.CadastrarProfessorCommand;
import br.com.gestao_escolar.controller.ListarAlunosCommand;
import br.com.gestao_escolar.controller.ListarProfessoresCommand;
import br.com.gestao_escolar.controller.CadastrarTurmaCommand;
import br.com.gestao_escolar.controller.ListarTurmasCommand;
import br.com.gestao_escolar.controller.CadastrarDisciplinaCommand;
import br.com.gestao_escolar.controller.ListarDisciplinasCommand;
import br.com.gestao_escolar.controller.CadastrarAtividadeCommand;
import br.com.gestao_escolar.controller.ListarAtividadesCommand;

public class Main {
    private static final String ARQ_ALUNOS = "alunos.dat";
    private static final String ARQ_PROFESSORES = "professores.dat";
    private static final String ARQ_TURMAS = "turmas.dat";
    private static final String ARQ_DISCIPLINAS = "disciplinas.dat";
    private static final String ARQ_ATIVIDADES = "atividades.dat";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Repositórios carregados da persistência
        Repositorio<Aluno> alunos = RepositorioFactory.criarRepositorio(ARQ_ALUNOS);
        Repositorio<Professor> professores = RepositorioFactory.criarRepositorio(ARQ_PROFESSORES);
        Repositorio<Turma> turmas = RepositorioFactory.criarRepositorio(ARQ_TURMAS);
        Repositorio<Disciplina> disciplinas = RepositorioFactory.criarRepositorio(ARQ_DISCIPLINAS);
        Repositorio<Atividade> atividades = RepositorioFactory.criarRepositorio(ARQ_ATIVIDADES);

        Map<Integer, Comando> comandos = new HashMap<>();
        comandos.put(1, new CadastrarAlunoCommand(alunos, entrada, ARQ_ALUNOS));
        comandos.put(2, new CadastrarProfessorCommand(professores, entrada, ARQ_PROFESSORES));
        comandos.put(3, new ListarAlunosCommand(alunos));
        comandos.put(4, new ListarProfessoresCommand(professores));
        comandos.put(5, new CadastrarTurmaCommand(turmas, entrada, ARQ_TURMAS));
        comandos.put(6, new ListarTurmasCommand(turmas));
        comandos.put(7, new CadastrarDisciplinaCommand(disciplinas, professores, entrada, ARQ_DISCIPLINAS));
        comandos.put(8, new ListarDisciplinasCommand(disciplinas));
        comandos.put(9, new CadastrarAtividadeCommand(atividades, entrada, ARQ_ATIVIDADES));
        comandos.put(10, new ListarAtividadesCommand(atividades));

        boolean ligado = true;
        System.out.println("Bem-vindo(a) ao sistema escolar!");

        try {
            do {
                System.out.println("\nMenu:");
                comandos.forEach((numero, comando) -> System.out.println(numero + " - " + comando.getNome()));
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                int escolha = entrada.nextInt();
                entrada.nextLine();

                if (escolha == 0) {
                    ligado = false;
                } else if (comandos.containsKey(escolha)) {
                    comandos.get(escolha).executar();
                } else {
                    System.out.println("Opção inválida.");
                }

            } while (ligado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            entrada.close();
        }

        System.out.println("Sistema finalizado.");
    }
}