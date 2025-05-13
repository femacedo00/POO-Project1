package br.com.gestao_escolar;

import java.util.List;
import java.util.Scanner;

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

    public static void listarAtividades(List<Atividade> atividades) {
        System.out.println("\n=== Lista de Atividades ===");
        if (atividades.isEmpty()) {
            System.out.println("Nenhuma atividade cadastrada.");
            return;
        }

        for (int i = 0; i < atividades.size(); i++) {
            Atividade a = atividades.get(i);
            System.out.printf("ID: %d | Tipo: %s | Nota: %.2f | Peso: %d\n",
                i + 1, a.getTipo(), a.getNota(), a.getPesoNota());
        }
    }

    public static double calcularMediaPonderada(List<Atividade> atividades) {
        if (atividades.isEmpty()) {
            System.out.println("Não há atividades para calcular a média.");
            return 0.0;
        }

        double somaNotasPonderadas = 0.0;
        int somaPesos = 0;

        for (Atividade a : atividades) {
            somaNotasPonderadas += a.getNota() * a.getPesoNota();
            somaPesos += a.getPesoNota();
        }

        if (somaPesos == 0) {
            System.out.println("A soma dos pesos é zero. Impossível calcular a média.");
            return 0.0;
        }

        return somaNotasPonderadas / somaPesos;
    }

    public static double calcularMediaProvas(List<Atividade> atividades) {
        double somaNotasPonderadas = 0.0;
        int somaPesos = 0;

        for (Atividade a : atividades) {
            if (a instanceof Prova) {
                somaNotasPonderadas += a.getNota() * a.getPesoNota();
                somaPesos += a.getPesoNota();
            }
        }

        if (somaPesos == 0) {
            System.out.println("Nenhuma prova cadastrada ou peso zero.");
            return 0.0;
        }

        return somaNotasPonderadas / somaPesos;
    }

    public static double calcularMediaTrabalhos(List<Atividade> atividades) {
        double somaNotasPonderadas = 0.0;
        int somaPesos = 0;

        for (Atividade a : atividades) {
            if (a instanceof Trabalho) {
                somaNotasPonderadas += a.getNota() * a.getPesoNota();
                somaPesos += a.getPesoNota();
            }
        }

        if (somaPesos == 0) {
            System.out.println("Nenhum trabalho cadastrado ou peso zero.");
            return 0.0;
        }

        return somaNotasPonderadas / somaPesos;
    }

    public static void alterarPeso(List<Atividade> atividades, Scanner scanner) {
        Atividade.listarAtividades(atividades);
        
        if (atividades.isEmpty()) return;

        System.out.print("Digite o ID da atividade que deseja alterar o peso: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (id < 1 || id > atividades.size()) {
            System.out.println("ID inválido.");
            return;
        }

        Atividade atividade = atividades.get(id - 1);

        System.out.printf("Peso atual da atividade (%s): %d\n", atividade.getTipo(), atividade.getPesoNota());
        System.out.print("Digite o novo peso: ");
        int novoPeso = Integer.parseInt(scanner.nextLine());

        if (novoPeso <= 0) {
            System.out.println("Peso inválido. O peso deve ser maior que zero.");
            return;
        }

        atividade.setPesoNota(novoPeso);
        System.out.println("Peso atualizado com sucesso!");
    }

}
