package br.com.gestao_escolar.model;

public class Disciplina extends Entidade {
    private String nome;
    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        super();
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }
}
