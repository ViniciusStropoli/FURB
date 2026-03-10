package Exe01;

public class Main {
    public static void main(String[] args) {

        // Caso 1: Testar método de inclusão
        System.out.println("--- Caso 1 ---");
        ListaEstatica lista1 = new ListaEstatica();
        lista1.inserir(5); lista1.inserir(10); lista1.inserir(15); lista1.inserir(20);
        System.out.println("Esperado: 5,10,15,20 | Obtido: " + lista1.toString());

        // Caso 2: Testar método de obtenção de tamanho
        System.out.println("\n--- Caso 2 ---");
        ListaEstatica lista2 = new ListaEstatica();
        lista2.inserir(5); lista2.inserir(10); lista2.inserir(15); lista2.inserir(20);
        System.out.println("Esperado: 4 | Obtido: " + lista2.getTamanho());

        // Caso 3: Testar método buscar() com elemento existente
        System.out.println("\n--- Caso 3 ---");
        ListaEstatica lista3 = new ListaEstatica();
        lista3.inserir(5); lista3.inserir(10); lista3.inserir(15); lista3.inserir(20);
        System.out.println("Esperado: 2 | Obtido: " + lista3.buscar(15));

        // Caso 4: Testar método buscar() com elemento inexistente
        System.out.println("\n--- Caso 4 ---");
        ListaEstatica lista4 = new ListaEstatica();
        lista4.inserir(5); lista4.inserir(10); lista4.inserir(15); lista4.inserir(20);
        System.out.println("Esperado: -1 | Obtido: " + lista4.buscar(30));

        // Caso 5: Testar método retirar()
        System.out.println("\n--- Caso 5 ---");
        ListaEstatica lista5 = new ListaEstatica();
        lista5.inserir(5); lista5.inserir(10); lista5.inserir(15); lista5.inserir(20);
        lista5.retirar(10);
        System.out.println("Esperado toString: 5,15,20 | Obtido: " + lista5.toString());
        System.out.println("Esperado tamanho: 3 | Obtido: " + lista5.getTamanho());

        // Caso 6: Testar inclusão que provoque redimensionamento
        System.out.println("\n--- Caso 6 ---");
        ListaEstatica lista6 = new ListaEstatica();
        for (int i = 1; i <= 15; i++) {
            lista6.inserir(i);
        }
        System.out.println("Esperado toString: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 | Obtido: " + lista6.toString());
        System.out.println("Esperado tamanho: 15 | Obtido: " + lista6.getTamanho());

        // Caso 7: Testar método obterElemento()
        System.out.println("\n--- Caso 7 ---");
        ListaEstatica lista7 = new ListaEstatica();
        lista7.inserir(5); lista7.inserir(10); lista7.inserir(15); lista7.inserir(20);
        System.out.println("Esperado: 20 | Obtido: " + lista7.obterElemento(3));

        // Caso 8: Testar lançamento de exceção no método obterElemento()
        System.out.println("\n--- Caso 8 ---");
        ListaEstatica lista8 = new ListaEstatica();
        lista8.inserir(5); lista8.inserir(10); lista8.inserir(15); lista8.inserir(20);
        try {
            int falha = lista8.obterElemento(5); // Deve dar erro, pois só vai de 0 a 3
            System.out.println("Isso não deve ser impresso. Obtido: " + falha);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esperado: Exceção | Obtido: Exceção capturada com sucesso! (" + e.getClass().getSimpleName() + ")");
        }

        // Caso 9: Certificar que liberar() remove todos os elementos
        System.out.println("\n--- Caso 9 ---");
        ListaEstatica lista9 = new ListaEstatica();
        lista9.inserir(5); lista9.inserir(10); lista9.inserir(15); lista9.inserir(20);
        lista9.liberar();
        System.out.println("Esperado: true | Obtido: " + lista9.estaVazia());
    }
}