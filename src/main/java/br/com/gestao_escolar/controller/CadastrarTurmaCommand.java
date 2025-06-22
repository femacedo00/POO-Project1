package br.com.gestao_escolar.controller;

import java.util.Scanner;

import br.com.gestao_escolar.controller.service.PersistenciaService;
import br.com.gestao_escolar.model.Turma;

public class CadastrarTurmaCommand implements Comando {
    private final Repositorio<Turma> repo;
    private final Scanner scanner;
    private final String caminho;

    public CadastrarTurmaCommand(Repositorio<Turma> repo, Scanner scanner, String caminho) {
        this.repo = repo;
        this.scanner = scanner;
        this.caminho = caminho;
    }

    public void executar() {
        System.out.print("Nome da turma: ");
        String nome = scanner.nextLine();
        repo.adicionar(new Turma(nome));
        PersistenciaService.salvar(repo, caminho);
    }

    public String getNome() {
        return "Cadastrar Turma";
    }
}
