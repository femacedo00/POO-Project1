package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Entidade;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface Repositorio<T extends Entidade> {
    void adicionar(T entidade);
    T buscarPorId(UUID id);
    List<T> listarTodos();
    void salvar(String caminho) throws IOException;
    void carregar(String caminho) throws IOException, ClassNotFoundException;
}
