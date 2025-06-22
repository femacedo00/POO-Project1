package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Professor;

public class ListarProfessoresCommand implements Comando {
    private final Repositorio<Professor> repo;

    public ListarProfessoresCommand(Repositorio<Professor> repo) {
        this.repo = repo;
    }

    public void executar() {
        System.out.println("Professores:");
        for (Professor p : repo.listarTodos()) {
            System.out.println("- " + p.getNome());
        }
    }

    public String getNome() {
        return "Listar Professores";
    }
}
