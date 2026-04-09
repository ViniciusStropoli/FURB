package Exe01;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Caso 1: Testar método de inclusão
        System.out.println("--- Caso 1 ---");
        ListaEstaticaGenerica lista1 = new ListaEstaticaGenerica();
        lista1.inserir(5); lista1.inserir(10); lista1.inserir(15); lista1.inserir(20);
        System.out.println("Esperado: 5,10,15,20 | Obtido: " + lista1.toString());

        // Caso 2: Testar método de obtenção de tamanho
        System.out.println("\n--- Caso 2 ---");
        ListaEstaticaGenerica lista2 = new ListaEstaticaGenerica();
        lista2.inserir(5); lista2.inserir(10); lista2.inserir(15); lista2.inserir(20);
        System.out.println("Esperado: 4 | Obtido: " + lista2.getTamanho());

        // Caso 3: Testar método buscar() com elemento existente
        System.out.println("\n--- Caso 3 ---");
        ListaEstaticaGenerica lista3 = new ListaEstaticaGenerica();
        lista3.inserir(5); lista3.inserir(10); lista3.inserir(15); lista3.inserir(20);
        System.out.println("Esperado: 2 | Obtido: " + lista3.buscar(15));

        // Caso 4: Testar método buscar() com elemento inexistente
        System.out.println("\n--- Caso 4 ---");
        ListaEstaticaGenerica lista4 = new ListaEstaticaGenerica();
        lista4.inserir(5); lista4.inserir(10); lista4.inserir(15); lista4.inserir(20);
        System.out.println("Esperado: -1 | Obtido: " + lista4.buscar(30));

        // Caso 5: Testar método retirar()
        System.out.println("\n--- Caso 5 ---");
        ListaEstaticaGenerica lista5 = new ListaEstaticaGenerica();
        lista5.inserir(5); lista5.inserir(10); lista5.inserir(15); lista5.inserir(20);
        lista5.retirar(10);
        System.out.println("Esperado toString: 5,15,20 | Obtido: " + lista5.toString());
        System.out.println("Esperado tamanho: 3 | Obtido: " + lista5.getTamanho());

        // Caso 6: Testar inclusão que provoque redimensionamento
        System.out.println("\n--- Caso 6 ---");
        ListaEstaticaGenerica lista6 = new ListaEstaticaGenerica();
        for (int i = 1; i <= 15; i++) {
            lista6.inserir(i);
        }
        System.out.println("Esperado toString: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 | Obtido: " + lista6.toString());
        System.out.println("Esperado tamanho: 15 | Obtido: " + lista6.getTamanho());

        // Caso 7: Testar método obterElemento()
        System.out.println("\n--- Caso 7 ---");
        ListaEstaticaGenerica lista7 = new ListaEstaticaGenerica();
        lista7.inserir(5); lista7.inserir(10); lista7.inserir(15); lista7.inserir(20);
        System.out.println("Esperado: 20 | Obtido: " + lista7.obterElemento(3));

        // Caso 8: Testar lançamento de exceção no método obterElemento()
        System.out.println("\n--- Caso 8 ---");
        ListaEstaticaGenerica<Integer> lista8 = new ListaEstaticaGenerica();
        lista8.inserir(5); lista8.inserir(10); lista8.inserir(15); lista8.inserir(20);
        try {
            int falha = lista8.obterElemento(5);
            System.out.println("Isso não deve ser impresso. Obtido: " + falha);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esperado: Exceção | Obtido: Exceção capturada com sucesso! (" + e.getClass().getSimpleName() + ")");
        }

        // Caso 9: Certificar que liberar() remove todos os elementos
        System.out.println("\n--- Caso 9 ---");
        ListaEstaticaGenerica lista9 = new ListaEstaticaGenerica();
        lista9.inserir(5); lista9.inserir(10); lista9.inserir(15); lista9.inserir(20);
        lista9.liberar();
        System.out.println("Esperado: true | Obtido: " + lista9.estaVazia());

        //Caso 10: inverter uma lista com 4 posições
        System.out.printf("\n--- Caso 10 ---");
        ListaEstaticaGenerica lista10 = new ListaEstaticaGenerica();
        lista10.inserir(5); lista10.inserir(10); lista10.inserir(15); lista10.inserir(20);
        System.out.println("\nPré inversão Esperado: 5, 10, 15, 20 | Obtido: " + lista10.toString());
        lista10.inverter();
        System.out.println("Esperado: 20, 15, 10, 5 | Obtido: " + lista10.toString());

        System.out.printf("\n--- Caso 11 ---");
        ListaEstaticaGenerica lista11 = new ListaEstaticaGenerica();
        lista11.inserir(5); lista11.inserir(10); lista11.inserir(15); lista11.inserir(20); lista11.inserir(25);
        System.out.println("\nPré inversão Esperado: 5, 10, 15, 20 | Obtido: " + lista11.toString());
        lista10.inverter();
        System.out.println("Esperado: 25, 20, 15, 10, 5 | Obtido: " + lista11.toString());

    }
}