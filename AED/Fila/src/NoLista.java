public class NoLista<T> {
    T info;
    NoLista<T> proximo;

    public NoLista(T info) {
        this.info = info;
        this.proximo = null;
    }
}