package br.com.leromaya.model.dao;

import br.com.leromaya.controller.GerenciadorScores;
import br.com.leromaya.model.vo.Score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class GerenciadorScoresArquivo implements GerenciadorScores {
    private List<Score> scores;

    public GerenciadorScoresArquivo() {
        scores = new ArrayList<>();
    }

    @Override
    public void adicionar(Score score) {
        scores.add(score);
        gravar(score);
    }

    @Override
    public List<Score> consulta() {
        return ler();
    }

    public void gravar(Score score) {
        try (PrintWriter out = new PrintWriter(new FileWriter("arquivo.txt", true))) {
            out.println(score.getJogador() + "," + score.getPontos());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Score> ler() {
        scores.clear();  // Limpa a lista antes de ler o arquivo novamente.
        try (BufferedReader in = new BufferedReader(new FileReader("arquivo.txt"))) {
            String linha;
            while ((linha = in.readLine()) != null) {
                String[] partes = linha.split(",");
                scores.add(new Score(partes[0], Integer.parseInt(partes[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}