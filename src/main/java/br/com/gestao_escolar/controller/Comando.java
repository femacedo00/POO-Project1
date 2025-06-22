package br.com.gestao_escolar.controller;

public interface Comando {
    void executar();
    String getNome(); // nome para exibir no menu
}