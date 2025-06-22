package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Disciplina;

public class ListarDisciplinasCommand implements Comando {
    private final Repositorio<Disciplina> repo;

    public ListarDisciplinasCommand(Repositorio<Disciplina> repo) {
        this.repo = repo;
    }

    public void executar() {
        System.out.println("Disciplinas:");
        for (Disciplina d : repo.listarTodos()) {
            System.out.println("- " + d.getNome() + " (Prof: " + d.getProfessor().getNome() + ")");
        }
    }

    public String getNome() {
        return "Listar Disciplinas";
    }
}
