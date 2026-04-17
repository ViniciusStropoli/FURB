public class TesteFilaPL01 {

    public static void main(String[] args) {

        System.out.println("CASO 1");
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        System.out.println("Esperado: true | Obtido: " + f1.estaVazia());

        System.out.println("\nCASO 2");
        FilaVetor<Integer> f2 = new FilaVetor<>(5);
        f2.inserir(10);
        System.out.println("Esperado: false | Obtido: " + f2.estaVazia());

        System.out.println("\nCASO 3");
        FilaVetor<Integer> f3 = new FilaVetor<>(10);
        f3.inserir(10);
        f3.inserir(20);
        f3.inserir(30);

        System.out.println("Esperado: 10 | Obtido: " + f3.retirar());
        System.out.println("Esperado: 20 | Obtido: " + f3.retirar());
        System.out.println("Esperado: 30 | Obtido: " + f3.retirar());
        System.out.println("Esperado: true | Obtido: " + f3.estaVazia());

        System.out.println("\nCASO 4");
        try {
            FilaVetor<Integer> f4 = new FilaVetor<>(3);
            f4.inserir(10);
            f4.inserir(20);
            f4.inserir(30);
            f4.inserir(40); // deve lançar exceção
            System.out.println("ERRO: exceção não lançada");
        } catch (FilaCheiaException e) {
            System.out.println("OK: FilaCheiaException lançada");
        }

        System.out.println("\nCASO 5");
        try {
            FilaVetor<Integer> f5 = new FilaVetor<>(3);
            f5.retirar(); // deve lançar exceção
            System.out.println("ERRO: exceção não lançada");
        } catch (FilaVaziaException e) {
            System.out.println("OK: FilaVaziaException lançada");
        }

        System.out.println("\nCASO 6");
        FilaVetor<Integer> f6 = new FilaVetor<>(5);
        f6.inserir(10);
        f6.inserir(20);
        f6.inserir(30);

        System.out.println("Peek esperado: 10 | Obtido: " + f6.peek());
        System.out.println("Retirar esperado: 10 | Obtido: " + f6.retirar());

        System.out.println("\nCASO 7");
        FilaVetor<Integer> f7 = new FilaVetor<>(5);
        f7.inserir(10);
        f7.inserir(20);
        f7.inserir(30);
        f7.liberar();

        System.out.println("Esperado: true | Obtido: " + f7.estaVazia());

        System.out.println("\nCASO 8");
        FilaVetor<Integer> f8a = new FilaVetor<>(5);
        f8a.inserir(10);
        f8a.inserir(20);
        f8a.inserir(30);

        FilaVetor<Integer> f8b = new FilaVetor<>(3);
        f8b.inserir(40);
        f8b.inserir(50);

        FilaVetor<Integer> f8c = f8a.criarFilaConcatenada(f8b);

        System.out.println("Fila concatenada esperada: [10, 20, 30, 40, 50]");
        System.out.println("Obtido: " + f8c);

        System.out.println("Fila original 1 deve permanecer: [10, 20, 30]");
        System.out.println("Obtido: " + f8a);

        System.out.println("Fila original 2 deve permanecer: [40, 50]");
        System.out.println("Obtido: " + f8b);

        System.out.println("Capacidade esperada: 5 | Obtido: " + f8c.getLimite());
    }
}