public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return lista.peekInicio();
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return lista.retirarDoInicio();
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}