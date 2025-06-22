package br.com.gestao_escolar;

import java.util.Scanner;

abstract class Entidade {
    String nome;
    int ano_nascimento;

    Entidade(String nome, int ano){
        this.nome = nome;
        this.ano_nascimento = ano;
    }

    void info(){
        System.out.println("Nome: " + this.nome + " || Ano de nascimento: " + this.ano_nascimento);
    }

    void editar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("O que deseja editar?");
        System.out.println("1 - Apenas  o nome");
        System.out.println("2 - Apenas  o ano");
        System.out.println("3 - Ambos");
        int usuario_escolha = Integer.parseInt(entrada.nextLine());

        switch (usuario_escolha) {
            case 1:
                System.out.println("Nome:");
                this.nome = entrada.nextLine();
                break;
        
            case 2:
                System.out.println("Ano de nascimento:");
                this.ano_nascimento = Integer.parseInt(entrada.nextLine());
                break;
        
            case 3:
                System.out.println("Nome:");
                this.nome = entrada.nextLine();
                System.out.println("Ano de nascimento:");
                this.ano_nascimento = Integer.parseInt(entrada.nextLine());
                break;

            default:
                System.out.println("Entidade não reconhecida!");
                break;
        }
    }
}
