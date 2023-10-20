package br.com.leromaya;

import br.com.leromaya.controller.GerenciadorScoresArquivo;
import br.com.leromaya.view.FrontScores;

/*
Nome do Integrante & RM
Matheus Dervage Maia -- RM550844
 */

public class MVC {
    public static void main(String[] args) {
        GerenciadorScoresArquivo g = new GerenciadorScoresArquivo();
        FrontScores frontScores = new FrontScores(g);
        frontScores.dialogar();

    }
}