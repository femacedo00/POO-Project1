package br.com.gestao_escolar.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class Entidade implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }
}
