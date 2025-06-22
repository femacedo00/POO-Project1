package br.com.gestao_escolar.controller;

import java.util.Scanner;

import br.com.gestao_escolar.controller.service.PersistenciaService;
import br.com.gestao_escolar.model.Atividade;
import br.com.gestao_escolar.model.Prova;
import br.com.gestao_escolar.model.Trabalho;

public class CadastrarAtividadeCommand implements Comando {
    private final Repositorio<Atividade> repo;
    private final Scanner scanner;
    private final String caminho;

    public CadastrarAtividadeCommand(Repositorio<Atividade> repo, Scanner scanner, String caminho) {
        this.repo = repo;
        this.scanner = scanner;
        this.caminho = caminho;
    }

    public void executar() {
        System.out.print("Tipo (1-Prova / 2-Trabalho): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        Atividade atividade = (tipo == 1) ? new Prova(titulo, peso) : new Trabalho(titulo, peso);
        repo.adicionar(atividade);
        PersistenciaService.salvar(repo, caminho);
    }

    public String getNome() {
        return "Cadastrar Atividade";
    }
}
