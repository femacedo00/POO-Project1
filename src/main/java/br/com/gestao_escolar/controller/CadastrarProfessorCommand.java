package br.com.gestao_escolar.controller;

import java.util.Scanner;

import br.com.gestao_escolar.controller.service.PersistenciaService;
import br.com.gestao_escolar.model.Professor;

public class CadastrarProfessorCommand implements Comando {
    private final Repositorio<Professor> repo;
    private final Scanner scanner;
    private final String caminho;

    public CadastrarProfessorCommand(Repositorio<Professor> repo, Scanner scanner, String caminho) {
        this.repo = repo;
        this.scanner = scanner;
        this.caminho = caminho;
    }

    public void executar() {
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        repo.adicionar(new Professor(nome));
        PersistenciaService.salvar(repo, caminho);
    }

    public String getNome() {
        return "Cadastrar Professor";
    }
}
