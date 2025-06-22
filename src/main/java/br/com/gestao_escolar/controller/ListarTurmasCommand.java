package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Turma;

public class ListarTurmasCommand implements Comando {
    private final Repositorio<Turma> repo;

    public ListarTurmasCommand(Repositorio<Turma> repo) {
        this.repo = repo;
    }

    public void executar() {
        System.out.println("Turmas:");
        for (Turma t : repo.listarTodos()) {
            System.out.println("- " + t.getId());
        }
    }

    public String getNome() {
        return "Listar Turmas";
    }
}
