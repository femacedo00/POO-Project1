package br.com.gestao_escolar.model;

public abstract class Atividade extends Entidade {
    private String titulo;
    private double peso;

    public Atividade(String titulo, double peso) {
        super();
        this.titulo = titulo;
        this.peso = peso;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPeso() {
        return peso;
    }
}
