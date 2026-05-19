package Exe01;

public class Main {

    public static void main(String[] args) {

        System.out.println("CASO 1 - Lista vazia");
        ListaEncadeada<Integer> lista1 = new ListaEncadeada<>();
        System.out.println("estaVazia(): " + lista1.estaVazia());
        System.out.println();

        System.out.println("CASO 2 - Lista não vazia");
        lista1.inserir(5);
        System.out.println("estaVazia(): " + lista1.estaVazia());
        System.out.println();

        System.out.println("CASO 3 - Inclusão de um número");
        ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();
        lista2.inserir(5);

        NoLista<Integer> no = lista2.getPrimeiro();

        if (no != null && no.getInfo() == 5 && no.getProximo() == null) {
            System.out.println("Teste OK");
        } else {
            System.out.println("Teste FALHOU");
        }
        System.out.println();

        System.out.println("CASO 4 - Inclusão de 3 números");
        ListaEncadeada<Integer> lista3 = new ListaEncadeada<>();
        lista3.inserir(5);
        lista3.inserir(10);
        lista3.inserir(15);

        NoLista<Integer> p = lista3.getPrimeiro();

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
        System.out.println();

        System.out.println("CASO 5 - Buscar primeiro elemento");
        ListaEncadeada<Integer> lista4 = new ListaEncadeada<>();
        lista4.inserir(5);
        lista4.inserir(10);
        lista4.inserir(15);
        lista4.inserir(20);

        NoLista<Integer> busca = lista4.buscar(20);

        if (busca != null) {
            System.out.println("Encontrado: " + busca.getInfo());
        }
        System.out.println();

        System.out.println("CASO 6 - Buscar elemento do meio");
        busca = lista4.buscar(15);

        if (busca != null) {
            System.out.println("Encontrado: " + busca.getInfo());
        }
        System.out.println();

        System.out.println("CASO 7 - Buscar elemento inexistente");
        busca = lista4.buscar(50);

        if (busca == null) {
            System.out.println("Resultado: null");
        }
        System.out.println();

        System.out.println("CASO 8 - Remover primeiro elemento");
        lista4.retirar(20);

        p = lista4.getPrimeiro();
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
        System.out.println();

        System.out.println("CASO 9 - Remover elemento do meio");
        lista4 = new ListaEncadeada<>();
        lista4.inserir(5);
        lista4.inserir(10);
        lista4.inserir(15);
        lista4.inserir(20);

        lista4.retirar(15);

        p = lista4.getPrimeiro();
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
        System.out.println();

        System.out.println("CASO 10 - obterNo posição 0");
        lista4 = new ListaEncadeada<>();
        lista4.inserir(5);
        lista4.inserir(10);
        lista4.inserir(15);
        lista4.inserir(20);

        System.out.println("Valor: " + lista4.obterNo(0).getInfo());
        System.out.println();

        System.out.println("CASO 11 - obterNo última posição");
        System.out.println("Valor: " + lista4.obterNo(3).getInfo());
        System.out.println();

        System.out.println("CASO 12 - obterNo posição inválida");
        try {
            lista4.obterNo(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exceção capturada: IndexOutOfBoundsException");
        }
        System.out.println();

        System.out.println("CASO 13 - obterComprimento lista vazia");
        ListaEncadeada<Integer> lista5 = new ListaEncadeada<>();
        System.out.println("Comprimento: " + lista5.obterComprimento());
        System.out.println();

        System.out.println("CASO 14 - obterComprimento lista não vazia");
        lista5.inserir(5);
        lista5.inserir(10);
        lista5.inserir(15);
        lista5.inserir(20);

        System.out.println("Comprimento: " + lista5.obterComprimento());
    }
}
