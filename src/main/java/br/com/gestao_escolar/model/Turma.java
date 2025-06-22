package br.com.gestao_escolar.model;

import java.util.ArrayList;
import java.util.List;

public class Turma extends Entidade {
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(String nome) {
        super();
        this.nome = nome;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}
