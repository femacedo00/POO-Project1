package br.com.gestao_escolar.controller.service;

import br.com.gestao_escolar.controller.Repositorio;
import br.com.gestao_escolar.controller.RepositorioMemoria;
import br.com.gestao_escolar.model.Aluno;
import br.com.gestao_escolar.model.Entidade;
import br.com.gestao_escolar.model.Professor;

import java.io.IOException;

public class PersistenciaService {

    public static <T extends Entidade> RepositorioMemoria<T> carregar(String caminho) {
        RepositorioMemoria<T> repo = new RepositorioMemoria<>();
        try {
            repo.carregar(caminho);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado anterior encontrado em: " + caminho);
        }
        return repo;
    }

    public static <T extends Entidade> void salvar(Repositorio<T> repositorio, String caminho) {
        try {
            repositorio.salvar(caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo " + caminho + ": " + e.getMessage());
        }
    }
}
