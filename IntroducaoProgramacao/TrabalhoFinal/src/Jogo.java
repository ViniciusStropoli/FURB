/*Dupla: Marlon Alfarth e Vinícius Stropoli */

import java.util.Scanner;

public class Jogo {

    private char[][] tabuleiro;
    private int jogadorLinha = 0;
    private int jogadorColuna = 0;
    private int linhaTesouro = 0;
    private int colunaTesouro = 0;
    private String guardarMovimentos = "";

    public void iniciar() {
        Scanner s = new Scanner(System.in);
        tabuleiro = new char[8][8];

        posicaoTesouro();
        preencherMatriz();
        tabuleiro[jogadorLinha][jogadorColuna] = 'P';
        atualizarTabuleiro();

        while (true) {
            System.out.print("\nDigite a direção(W, A, S, D): ");
            String andar = s.nextLine().toUpperCase();

            if (movimento(andar)) {
                atualizarTabuleiro();

                if (jogadorLinha == linhaTesouro && jogadorColuna == colunaTesouro) {
                    tabuleiro[linhaTesouro][colunaTesouro] = 'T';
                    System.out.println("");
                    atualizarTabuleiro();
                    System.out.println("\nVocê achou o tesouro!!");
                    System.out.println("\nCaminho percorrido: " + guardarMovimentos);
                    break;
                }
            }
        }

        s.close();
    }

    private void posicaoTesouro() {
        do {
            linhaTesouro = (int) (Math.random() * 8);
            colunaTesouro = (int) (Math.random() * 8);
        } while (linhaTesouro == 0 || colunaTesouro == 0);
        //System.out.println("Tesouro em: " + linhaTesouro + " " + colunaTesouro);
    }

    private void preencherMatriz() {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                tabuleiro[linha][coluna] = '-';
            }
        }
    }

    private void atualizarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
        }
    }

    private boolean movimento(String andar) {
        int novaLinha = jogadorLinha;
        int novaColuna = jogadorColuna;

        switch (andar) {
            case "W":
                novaLinha--;
                guardarMovimentos += "CIMA ";
                break;
            case "S":
                novaLinha++;
                guardarMovimentos += "BAIXO ";
                break;
            case "A":
                novaColuna--;
                guardarMovimentos += "ESQUERDA ";
                break;
            case "D":
                novaColuna++;
                guardarMovimentos += "DIREITA ";
                break;
            default:
                System.out.println("Movimento inválido.");
                return false;
        }

        if (novaLinha < 0 || novaLinha >= 8 || novaColuna < 0 || novaColuna >= 8) {
            System.out.println("Movimento inválido, saiu do tabuleiro.");
            return false;
        }

        tabuleiro[jogadorLinha][jogadorColuna] = '-';
        jogadorLinha = novaLinha;
        jogadorColuna = novaColuna;
        tabuleiro[jogadorLinha][jogadorColuna] = 'P';

        return true;
    }
}