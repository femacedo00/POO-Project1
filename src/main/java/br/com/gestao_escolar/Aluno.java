package br.com.gestao_escolar;

import java.util.List;

public class Aluno extends Entidade {
    private int ra;
    static int count = 1;

    Aluno(String nome, int ano){
        super(nome, ano);
        this.ra = count;
        count++;
    }

    @Override
    void info(){
        System.out.println("RA: " + this.ra + " || Nome: " + this.nome + " || Ano de nascimento: " + this.ano_nascimento);
    }

    public static void listar(List<Aluno> alunos){
        System.out.println("=== Lista de Alunos ===");
        for (Aluno aluno : alunos)  {
            aluno.info();
        }
    }
}
