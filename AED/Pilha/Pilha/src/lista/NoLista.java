package lista;

public class NoLista<T> {
    public T info;
    public NoLista<T> proximo;

    public NoLista(T info) {
        this.info = info;
        this.proximo = null;
    }
}