package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Atividade;

public class ListarAtividadesCommand implements Comando {
    private final Repositorio<Atividade> repo;

    public ListarAtividadesCommand(Repositorio<Atividade> repo) {
        this.repo = repo;
    }

    public void executar() {
        System.out.println("Atividades:");
        for (Atividade a : repo.listarTodos()) {
            System.out.println("- " + a.getTitulo() + " (peso: " + a.getPeso() + ")");
        }
    }

    public String getNome() {
        return "Listar Atividades";
    }
}
