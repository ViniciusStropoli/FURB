package teste;

import pilha.PilhaLista;

public class TestePilhaLista {
    public static void main(String[] args) {

        PilhaLista<Integer> p = new PilhaLista<>();

        p.push(10);
        p.push(20);
        p.push(30);

        System.out.println(p.pop()); // 30
        System.out.println(p.pop()); // 20
        System.out.println(p.pop()); // 10
        System.out.println(p.estaVazia()); // true
    }
}