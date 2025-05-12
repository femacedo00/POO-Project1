package br.com.gestao_escolar;

import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome;
    private int cargaHoraria;
    private Turma turma;
    private ArrayList<Atividade> atividades;
    private static int count = 1;

    private static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();

    public Disciplina(String nome, int cargaHoraria, Turma turma) {
        this.id = count;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.turma = turma;
        this.atividades = new ArrayList<>();
        listaDisciplinas.add(this); // adiciona a disciplina na lista global
        count++;
    }
    public static ArrayList<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) {
        atividades.remove(atividade);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public static void listar() {
        System.out.println("=== Lista de Disciplinas ===");
        for (Disciplina d : listaDisciplinas) {
            System.out.println("ID: " + d.getId() + 
                               ", Nome: " + d.getNome() + 
                               ", Carga Horária: " + d.getCargaHoraria() + 
                               ", Turma: " + (d.getTurma() != null ? d.getTurma().nomeTurma() : "Nenhuma"));
        }
    }
}
