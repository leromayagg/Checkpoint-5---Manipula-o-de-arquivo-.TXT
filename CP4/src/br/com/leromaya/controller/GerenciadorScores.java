package br.com.leromaya.controller;

import br.com.leromaya.model.vo.Score;

import java.util.List;

public interface GerenciadorScores {
    void adicionar(Score score);
    List<Score> consulta();
}
