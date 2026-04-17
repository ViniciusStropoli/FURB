public class TesteFilaLista {

    public static void main(String[] args) {

        System.out.println("CASO 1");
        FilaLista<Integer> f1 = new FilaLista<>();
        System.out.println("Esperado: true | Obtido: " + f1.estaVazia());

        System.out.println("\nCASO 2");
        FilaLista<Integer> f2 = new FilaLista<>();
        f2.inserir(10);
        System.out.println("Esperado: false | Obtido: " + f2.estaVazia());

        System.out.println("\nCASO 3");
        FilaLista<Integer> f3 = new FilaLista<>();
        f3.inserir(10);
        System.out.println("Esperado: 10 | Obtido: " + f3.retirar());

        System.out.println("\nCASO 4");
        FilaLista<Integer> f4 = new FilaLista<>();
        f4.inserir(10);
        f4.inserir(20);
        f4.inserir(30);

        System.out.println("Peek esperado: 10 | Obtido: " + f4.peek());
        System.out.println("Retirar esperado: 10 | Obtido: " + f4.retirar());
        System.out.println("Fila atual: " + f4);

        System.out.println("\nCASO 5");
        FilaLista<Integer> f5 = new FilaLista<>();
        f5.inserir(10);
        f5.inserir(20);
        f5.inserir(30);
        f5.liberar();

        System.out.println("Esperado: true | Obtido: " + f5.estaVazia());
    }
}