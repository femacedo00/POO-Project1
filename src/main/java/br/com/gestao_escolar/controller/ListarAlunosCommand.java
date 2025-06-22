package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Aluno;

public class ListarAlunosCommand implements Comando {
    private final Repositorio<Aluno> repo;

    public ListarAlunosCommand(Repositorio<Aluno> repo) {
        this.repo = repo;
    }

    public void executar() {
        System.out.println("Alunos:");
        for (Aluno a : repo.listarTodos()) {
            System.out.println("- " + a.getNome());
        }
    }

    public String getNome() {
        return "Listar Alunos";
    }
}
