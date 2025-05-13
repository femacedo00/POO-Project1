package br.com.gestao_escolar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Atividade> atividades = new ArrayList<>();
        
        int ano;
        String nome;
        int entidade;
        int rp;
        int ra;
        int codigo_turma;
        Professor prof_escolhido;

        int usuario_escolha;
        boolean ligado = true;

        System.out.println("Bem-vindo(a) ao sistema escolar!");

        do {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Cadastrar uma entidade");
            System.out.println("2 - Listar entidades");
            System.out.println("3 - Editar entidade");
            System.out.println("4 - Cadastrar uma turma");
            System.out.println("5 - Listar Turmas");
            System.out.println("6 - Editar uma Turma");
            System.out.println("7 - Gerenciar disciplinas");
            System.out.println("8 - Listar disciplinas");
            System.out.println("9 - Gerenciar atividades");
            System.out.println("10 - Listar atividades");
            System.out.println("0 - Sair");
            usuario_escolha = Integer.parseInt(entrada.nextLine());

            switch (usuario_escolha) {
                case 0:
                    ligado = false;
                    break;
                
                case 1:
                    System.out.println("Nome:");
                    nome = entrada.nextLine();

                    System.out.println("Ano de nascimento:");
                    ano = Integer.parseInt(entrada.nextLine());

                    System.out.println("Tipo de entidade:");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    entidade = Integer.parseInt(entrada.nextLine());

                    switch (entidade) {
                        case 1:
                            alunos.add(new Aluno(nome, ano));
                            break;
                    
                        case 2:
                            professores.add(new Professor(nome, ano));
                            break;
                    
                        default:
                            System.out.println("Entidade não reconhecida!");
                            break;
                    }
                    break;
                
                case 2:
                    System.out.println("Tipo de entidade:");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    entidade = Integer.parseInt(entrada.nextLine());

                    switch (entidade) {
                        case 1:
                            Aluno.listar(alunos);
                            break;
                    
                        case 2:
                            Professor.listar(professores);
                            break;
                    
                        default:
                            System.out.println("Entidade não reconhecida!");
                            break;
                    }
                    break;
                
                case 3:
                    System.out.println("Tipo de entidade:");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    entidade = Integer.parseInt(entrada.nextLine());

                    switch (entidade) {
                        case 1:
                            System.out.println("RA do aluno:");
                            ra = Integer.parseInt(entrada.nextLine()) - 1;
                            alunos.get(ra).editar();
                            break;
                    
                        case 2:
                            System.out.println("RP do professor:");
                            rp = Integer.parseInt(entrada.nextLine()) - 1;
                            professores.get(rp).editar();
                            break;
                    
                        default:
                            System.out.println("Entidade não reconhecida!");
                            break;
                    }
                    break;
                
                case 4:
                    System.out.println("RP do professor:");
                    rp = Integer.parseInt(entrada.nextLine()) - 1;
                    prof_escolhido = professores.get(rp);

                    System.out.println("Adicionar todos os alunos, um específico ou nenhum?");
                    System.out.println("1 - Todos");
                    System.out.println("2 - Específico");
                    System.out.println("3 - Nenhum");
                    usuario_escolha  = Integer.parseInt(entrada.nextLine());

                    switch (usuario_escolha) {
                        case 1:
                            turmas.add(new Turma(prof_escolhido, alunos));
                            break;
                    
                        case 2:
                            System.out.println("RA do aluno:");
                            ra = Integer.parseInt(entrada.nextLine()) - 1;
                            turmas.add(new Turma(prof_escolhido, alunos.get(ra)));
                            break;
                    
                        case 3:
                            turmas.add(new Turma(prof_escolhido));
                            break;
                    
                        default:
                            System.out.println("Comando não reconhecido!");
                            break;
                    }
                    break;
            
                case 5:
                    Turma.listar(turmas);
                    break;
            
                case 6:
                    System.out.println("Código da turma:");
                    codigo_turma = Integer.parseInt(entrada.nextLine()) - 1;
                    Turma turma_escolhida = turmas.get(codigo_turma);

                    System.out.println("O que você deseja editar?");
                    System.out.println("1 - Editar nome da turma");
                    System.out.println("2 - Alterar o professor");
                    System.out.println("3 - Incluir um Aluno");
                    System.out.println("4 - Remover um Aluno");
                    System.out.println("0 - Voltar ao menu principal");
                    
                    usuario_escolha = Integer.parseInt(entrada.nextLine());

                    switch (usuario_escolha) {
                        case 1:
                            System.out.println("Novo nome:");
                            String novo_nome = entrada.nextLine();
                            turma_escolhida.editNomeTurma(novo_nome);
                            break;
                    
                        case 2:
                            System.out.println("RP do novo professor:");
                            rp = Integer.parseInt(entrada.nextLine()) - 1;
                            turma_escolhida.editProfessor(professores.get(rp));
                            break;
                    
                        case 3:
                            System.out.println("RA do novo aluno:");
                            ra = Integer.parseInt(entrada.nextLine()) - 1;
                            turma_escolhida.addAluno(alunos.get(ra));
                            break;
                    
                        case 4:
                            System.out.println("RA do aluno a ser removido:");
                            ra = Integer.parseInt(entrada.nextLine()) - 1;
                            turma_escolhida.removeAluno(alunos.get(ra));
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Comando não reconhecido!");
                            break;
                    }
                    break;
            
                case 7:
                    int opcaoDisciplina;
                    System.out.println("\n=== Gerenciar Disciplinas ===");
                    System.out.println("1 - Cadastrar nova disciplina");
                    System.out.println("2 - Editar nome da disciplina");
                    System.out.println("3 - Editar carga horária");
                    System.out.println("4 - Alterar turma");
                    System.out.println("5 - Excluir disciplina");
                    System.out.println("6 - Adicionar atividade");
                    System.out.println("7 - Remover atividade");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoDisciplina = Integer.parseInt(entrada.nextLine());

                    switch (opcaoDisciplina) {
                        case 1: // Cadastrar nova disciplina
                            System.out.print("Nome: ");
                            String nome_disc = entrada.nextLine();
                            System.out.print("Carga horária: ");
                            int carga = Integer.parseInt(entrada.nextLine());
                            Turma.listar(turmas);
                            System.out.print("Id da turma: ");
                            int idTurma = Integer.parseInt(entrada.nextLine());
                            turma_escolhida = turmas.get(idTurma-1);
                            disciplinas.add(new Disciplina(nome_disc, carga, turma_escolhida));
                            System.out.println("Disciplina cadastrada com sucesso.");
                            break;

                        case 2: // editar nome da disciplina
                            System.out.print("ID da disciplina: ");
                            int id_edit = Integer.parseInt(entrada.nextLine());
                            for (Disciplina d : Disciplina.getListaDisciplinas()) {
                                if (d.getId() == id_edit) {
                                    System.out.print("Novo nome: ");
                                    d.setNome(entrada.nextLine());
                                    System.out.println("Nome atualizado.");
                                    break;
                                }
                            }
                            break;

                        case 3: // editar carga horária
                            System.out.print("ID da disciplina: ");
                            int id_carga = Integer.parseInt(entrada.nextLine());
                            for (Disciplina d : Disciplina.getListaDisciplinas()) {
                                if (d.getId() == id_carga) {
                                    System.out.print("Nova carga horária: ");
                                    d.setCargaHoraria(Integer.parseInt(entrada.nextLine()));
                                    System.out.println("Carga horária atualizada.");
                                    break;
                                }
                            }
                            break;

                        case 4: // Alterar turma
                            System.out.print("ID da disciplina: ");
                            int id_disciplina_alt_turma = Integer.parseInt(entrada.nextLine());
                            Disciplina disciplina_escolhida_turma_alt = disciplinas.get(id_disciplina_alt_turma-1);
                            System.out.print("ID turma nova: ");
                            int id_nova_turma = Integer.parseInt(entrada.nextLine());
                            Turma nova_turma = turmas.get(id_nova_turma-1);
                            disciplina_escolhida_turma_alt.setTurma(nova_turma);
                            break;

                        case 5: // Excluir disciplina
                            System.out.print("ID da disciplina a remover: ");
                            int id_remove = Integer.parseInt(entrada.nextLine());
                            Disciplina.getListaDisciplinas().removeIf(d -> d.getId() == id_remove);
                            System.out.println("Disciplina removida.");
                            break;

                        case 6: // Adicionar atividade
                            System.out.print("ID da disciplina: ");
                            int id_disciplina_add = Integer.parseInt(entrada.nextLine());
                            Disciplina disciplina_escolhida_atv_add = disciplinas.get(id_disciplina_add-1);
                            System.out.print("ID da atividade a ser incluida: ");
                            int id_atv_add = Integer.parseInt(entrada.nextLine());
                            Atividade atv_escolhida_add = atividades.get(id_atv_add-1);
                            disciplina_escolhida_atv_add.adicionarAtividade(atv_escolhida_add);
                            break;

                        case 7: // Remover atividade
                            System.out.print("ID da disciplina: ");
                            int id_disciplina_rem = Integer.parseInt(entrada.nextLine());
                            Disciplina disciplina_escolhida_atv_rem = disciplinas.get(id_disciplina_rem-1);
                            System.out.print("ID da atividade a ser excluida: ");
                            int id_atv_rem = Integer.parseInt(entrada.nextLine());
                            Atividade atv_escolhida_rem = atividades.get(id_atv_rem-1);
                            disciplina_escolhida_atv_rem.removerAtividade(atv_escolhida_rem);
                            break;

                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;

                        default:
                            System.out.println("Comando não reconhecido!");
                    }
                    break;
                case 8:
                    Disciplina.listar();
                    break;
                case 9:
                    int opcaoAtividade;
                    System.out.println("\n=== Gerenciar Atividades ===");
                    System.out.println("1 - Cadastrar nova atividade");
                    System.out.println("2 - Remover atividade");
                    System.out.println("3 - Alterar peso atividade");
                    System.out.println("4 - Calcular média de provas");
                    System.out.println("5 - Calcular média de trabalhos");
                    System.out.println("6 - Calcular média total");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoAtividade = Integer.parseInt(entrada.nextLine());

                    switch (opcaoAtividade) {
                        case 1: 
                            System.out.println("Tipo de atividade:");
                            System.out.println("1 - Prova");
                            System.out.println("2 - Trabalho");
                            int tipoAtv = Integer.parseInt(entrada.nextLine());

                            System.out.print("Nota: ");
                            double nota = Double.parseDouble(entrada.nextLine());

                            System.out.print("Peso da nota: ");
                            int peso = Integer.parseInt(entrada.nextLine());

                            Atividade novaAtv = null;

                            if (tipoAtv == 1) {
                                novaAtv = new Prova(nota, peso);
                            } else if (tipoAtv == 2) {
                                novaAtv = new Trabalho(nota, peso);
                            } else {
                                System.out.println("Tipo inválido.");
                                break;
                            }

                            atividades.add(novaAtv);
                            System.out.println(novaAtv.getTipo() + " adicionada com sucesso! ID: " + atividades.size());
                            break;
                        case 2:
                            Atividade.listarAtividades(atividades); 
                            if (atividades.isEmpty()) break;

                            System.out.print("Digite o ID da atividade que deseja remover: ");
                            int idRemover = Integer.parseInt(entrada.nextLine());
                            if (idRemover < 1 || idRemover > atividades.size()) {
                                System.out.println("ID inválido.");
                            } else {
                                Atividade removida = atividades.remove(idRemover - 1);
                                System.out.printf("Atividade '%s' removida com sucesso!\n", removida.getTipo());
                            }
                            break;
                        case 3:
                            Atividade.alterarPeso(atividades, entrada);
                            break;
                        case 4:
                            double mediaProvas = Atividade.calcularMediaProvas(atividades);
                            System.out.printf("Média Ponderada das Provas: %.2f\n", mediaProvas);
                            break;
                        case 5:
                            double mediaTrabalhos = Atividade.calcularMediaTrabalhos(atividades);
                            System.out.printf("Média Ponderada dos Trabalhos: %.2f\n", mediaTrabalhos);
                            break;
                        case 6:
                            double media = Atividade.calcularMediaPonderada(atividades);
                            System.out.printf("Média Ponderada Total: %.2f\n", media);
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Comando não reconhecido!");
                            break;
                    }
                break;
                case 10:
                    Atividade.listarAtividades(atividades);
                    break;
                default:
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (ligado);

        entrada.close();

        System.out.println("Finalizando...");
    }
}