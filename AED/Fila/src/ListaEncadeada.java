public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<>(valor);

        if (estaVazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    public T retirarDoInicio() {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia");
        }

        T valor = primeiro.info;
        primeiro = primeiro.proximo;

        if (primeiro == null) {
            ultimo = null;
        }

        return valor;
    }

    public T peekInicio() {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia");
        }
        return primeiro.info;
    }

    public void liberar() {
        primeiro = null;
        ultimo = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.info);
            if (atual.proximo != null) {
                sb.append(", ");
            }
            atual = atual.proximo;
        }

        return sb.toString();
    }
}