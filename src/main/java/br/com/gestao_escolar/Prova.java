package br.com.gestao_escolar;

public class Prova extends Atividade {
   
    public Prova(double nota, int pesoNota) {
       super(nota, pesoNota);
   }

   @Override
   public String getTipo() {
       return "Prova";
   }
}
