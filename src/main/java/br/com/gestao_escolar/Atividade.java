package br.com.gestao_escolar;

public abstract class Atividade {

    private double nota;
    private int pesoNota;

    public Atividade(double nota, int pesoNota) {
        this.nota = nota;
        this.pesoNota = pesoNota;
    }

    public abstract String getTipo();

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getPesoNota() {
        return pesoNota;
    }

    public void setPesoNota(int pesoNota) {
        this.pesoNota = pesoNota;
    }

}
