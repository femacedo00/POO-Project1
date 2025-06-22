package br.com.gestao_escolar.controller;

import br.com.gestao_escolar.model.Entidade;

import java.io.*;
import java.util.*;

public class RepositorioMemoria<T extends Entidade> implements Repositorio<T>, Serializable {
    private static final long serialVersionUID = 1L;
    private Map<UUID, T> dados = new HashMap<>();

    @Override
    public void adicionar(T entidade) {
        dados.put(entidade.getId(), entidade);
    }

    @Override
    public T buscarPorId(UUID id) {
        return dados.get(id);
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(dados.values());
    }

    @Override
    public void salvar(String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(this);
        }
    }

    @Override
    public void carregar(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            RepositorioMemoria<T> repo = (RepositorioMemoria<T>) ois.readObject();
            this.dados = repo.dados;
        }
    }
}
