package br.com.leromaya.view;

import br.com.leromaya.controller.GerenciadorScores;
import br.com.leromaya.model.vo.Score;

import java.util.List;
import java.util.Scanner;

public class FrontScores {
    private GerenciadorScores gerenciador;

    public FrontScores(GerenciadorScores gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void dialogar() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            menu();
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite o nome do jogador:\n");
                    String jogador = sc.nextLine();
                    System.out.println("Digite os pontos:\n");
                    int pontos = sc.nextInt();
                    sc.nextLine();  // Consume newline left-over
                    adicionar(jogador, pontos);
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

    public int menu() {
        System.out.println("\n1. Adicionar score");
        System.out.println("2. Listar scores");
        System.out.println("3. Sair");
        System.out.print("\nEscolha uma opção: ");
        return menu;
    }

    public void adicionar(String jogador, int pontos) {
        Score score = new Score(jogador, pontos);
        gerenciador.adicionar(score);
    }

    public void listar() {
        List<Score> scores = gerenciador.consulta();
        System.out.println("\n# Lista de score:\n");
        for (Score score : scores) {
            System.out.println("- " + score.getPontos() +" "+ score.getJogador());
        }
    }

}
