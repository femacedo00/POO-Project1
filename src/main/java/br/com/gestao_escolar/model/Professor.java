package br.com.gestao_escolar.model;

public class Professor extends Entidade {
    private String nome;

    public Professor(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
