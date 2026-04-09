package ListaEncadeadaDupla;

public class Main {
    public static void main(String[] args) {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(20);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(5);

        System.out.println(lista);

        lista.exibirOrdem();

        lista.retirar(10);
        System.out.println(lista);

        System.out.println(lista.buscar(15));

        lista.liberar();
        System.out.println(lista);
    }
}