package br.com.gestao_escolar.controller;

import java.util.List;
import java.util.Scanner;

import br.com.gestao_escolar.controller.service.PersistenciaService;
import br.com.gestao_escolar.model.Disciplina;
import br.com.gestao_escolar.model.Professor;

public class CadastrarDisciplinaCommand implements Comando {
    private final Repositorio<Disciplina> repo;
    private final Repositorio<Professor> profRepo;
    private final Scanner scanner;
    private final String caminho;

    public CadastrarDisciplinaCommand(Repositorio<Disciplina> repo, Repositorio<Professor> profRepo, Scanner scanner, String caminho) {
        this.repo = repo;
        this.profRepo = profRepo;
        this.scanner = scanner;
        this.caminho = caminho;
    }

    public void executar() {
        if (profRepo.listarTodos().isEmpty()) {
            System.out.println("Cadastre professores antes.");
            return;
        }
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        List<Professor> listaProf = profRepo.listarTodos();
        for (int i = 0; i < listaProf.size(); i++) {
            System.out.println(i + " - " + listaProf.get(i).getNome());
        }
        System.out.print("Escolha o professor: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        repo.adicionar(new Disciplina(nome, listaProf.get(indice)));
        PersistenciaService.salvar(repo, caminho);
    }

    public String getNome() {
        return "Cadastrar Disciplina";
    }
}
