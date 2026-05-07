public class Main {

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             /     / \
            4     5   6
        */

        NoArvoreBinaria<Integer> no4 =
                new NoArvoreBinaria<>(4);

        NoArvoreBinaria<Integer> no5 =
                new NoArvoreBinaria<>(5);

        NoArvoreBinaria<Integer> no6 =
                new NoArvoreBinaria<>(6);

        NoArvoreBinaria<Integer> no2 =
                new NoArvoreBinaria<>(2, no4, null);

        NoArvoreBinaria<Integer> no3 =
                new NoArvoreBinaria<>(3, no5, no6);

        NoArvoreBinaria<Integer> no1 =
                new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore =
                new ArvoreBinaria<>();

        arvore.setRaiz(no1);

        System.out.println("Árvore vazia? "
                + arvore.estaVazia());

        System.out.println("Pré-ordem: "
                + arvore.toString());

        System.out.println("Pertence 1? "
                + arvore.pertence(1));

        System.out.println("Pertence 3? "
                + arvore.pertence(3));

        System.out.println("Pertence 6? "
                + arvore.pertence(6));

        System.out.println("Pertence 10? "
                + arvore.pertence(10));

        System.out.println("Quantidade de nós: "
                + arvore.contarNos());
    }
}