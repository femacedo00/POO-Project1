package br.com.gestao_escolar;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codigo;
    private static int count = 1;
    private String nome;
    public Professor professor;
    public List<Aluno> alunos = new ArrayList<>();
    
    Turma(Professor professor) {
        editNomeTurma(count);
        this.codigo = count;
        this.professor = professor;
        count++;
    }
    
    Turma(Professor professor, Aluno aluno) {
        editNomeTurma(count);
        this.codigo = count;
        this.professor = professor;
        this.alunos.add(aluno);
        count++;
    }
    
    Turma(Professor professor, List<Aluno> alunos) {
        editNomeTurma(count);
        this.codigo = count;
        this.professor = professor;
        for (Aluno aluno : alunos)  {
            this.alunos.add(aluno);
        }
        count++;
    }

    int codigoTurma() {
        return this.codigo;
    }

    String nomeTurma() {
        return this.nome;
    }

    void editNomeTurma(int count) {
        this.nome = "Turma " + count;
    }

    void editNomeTurma(String nome) {
        this.nome = nome;
    }

    void editProfessor(Professor novoProfessor) {
        this.professor = novoProfessor;
    }

    void addAluno(Aluno novoAluno) {
        this.alunos.add(novoAluno);
    }

    void removeAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    void info() {
        System.out.println("Código: " + codigoTurma());
        System.out.println("Nome: " + nomeTurma());
        System.out.println("Professor:");
        this.professor.info();
        System.out.println("Alunos: ");
        Aluno.listar(this.alunos);
    }

    public static void listar(List<Turma> turmas){
        System.out.println("=== Lista de Turmas ===");
        for (Turma turma : turmas)  {
            System.out.println("======");
            turma.info();
            System.out.println("======");
        }
    }
}
