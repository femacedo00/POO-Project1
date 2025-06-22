package br.com.gestao_escolar.controller.service;

import br.com.gestao_escolar.controller.Repositorio;
import br.com.gestao_escolar.controller.RepositorioMemoria;
import br.com.gestao_escolar.model.Entidade;

public class RepositorioFactory {
    public static <T extends Entidade> Repositorio<T> criarRepositorio(String caminho) {
        return PersistenciaService.carregar(caminho); // já retorna RepositorioMemoria<T>, que implementa Repositorio<T>
    }
}
