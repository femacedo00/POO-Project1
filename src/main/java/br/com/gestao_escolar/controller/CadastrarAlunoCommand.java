package br.com.gestao_escolar.controller;

import java.util.Scanner;

import br.com.gestao_escolar.controller.service.PersistenciaService;
import br.com.gestao_escolar.model.Aluno;

public class CadastrarAlunoCommand implements Comando {
    private final Repositorio<Aluno> repositorio;
    private final Scanner entrada;
    private final String caminho;

    public CadastrarAlunoCommand(Repositorio<Aluno> repositorio, Scanner entrada, String caminho) {
        this.repositorio = repositorio;
        this.entrada = entrada;
        this.caminho = caminho;
    }

    @Override
    public void executar() {
        System.out.print("Nome do aluno: ");
        String nome = entrada.nextLine();
        repositorio.adicionar(new Aluno(nome));
        PersistenciaService.salvar(repositorio, caminho);
        System.out.println("Aluno cadastrado!");
    }

    @Override
    public String getNome() {
        return "Cadastrar Aluno";
    }
}
