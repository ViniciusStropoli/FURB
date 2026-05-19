package lista;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void inserirInicio(T info) {
        NoLista<T> novo = new NoLista<>(info);
        novo.proximo = primeiro;
        primeiro = novo;
    }

    public T retirarInicio() {
        if (estaVazia()) return null;

        T valor = primeiro.info;
        primeiro = primeiro.proximo;
        return valor;
    }

    public T getPrimeiro() {
        if (estaVazia()) return null;
        return primeiro.info;
    }

    public void liberar() {
        primeiro = null;
    }
}