package br.com.gestao_escolar;

import java.util.List;

public class Professor extends Entidade {
    private int rp;
    static int count = 1;

    Professor(String nome, int ano){
        super(nome, ano);
        this.rp = count;
        count++;
    }

    @Override
    void info(){
        System.out.println("RP: " + this.rp + " || Nome: " + this.nome + " || Ano de nascimento: " + this.ano_nascimento);
    }
    
    public static void listar(List<Professor> professores){
        System.out.println("=== Lista de Professores ===");
        for (Professor professor : professores)  {
            professor.info();
        }
    }
}
