package br.com.gestao_escolar;

public class Trabalho extends Atividade {
    public Trabalho(double nota, int pesoNota) {
        super(nota, pesoNota);
    }

    @Override
    public String getTipo() {
        return "Trabalho";
    }
}
