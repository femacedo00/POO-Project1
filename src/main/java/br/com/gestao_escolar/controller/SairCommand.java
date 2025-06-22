package br.com.gestao_escolar.controller;

public class SairCommand implements Comando {
    public void executar() {
        System.out.println("Sistema encerrado.");
        System.exit(0);
    }

    public String getNome() {
        return "Sair";
    }
}

