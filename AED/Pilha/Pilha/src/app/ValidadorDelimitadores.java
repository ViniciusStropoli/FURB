package app;

import pilha.PilhaVetor;
import java.util.Scanner;

public class ValidadorDelimitadores {

    public static boolean validar(String expr) {
        PilhaVetor<Character> pilha = new PilhaVetor<>(expr.length());

        for (char c : expr.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {

                if (pilha.estaVazia()) return false;

                char topo = pilha.pop();

                if ((c == ')' && topo != '(') ||
                        (c == ']' && topo != '[') ||
                        (c == '}' && topo != '{')) {
                    return false;
                }
            }
        }

        return pilha.estaVazia();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a expressão: ");
        String expr = sc.nextLine();

        if (validar(expr)) {
            System.out.println("CORRETO");
        } else {
            System.out.println("INCORRETO");
        }

        sc.close();
    }
}