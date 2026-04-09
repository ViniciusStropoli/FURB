package ListaCircular;

public class NoLista<T> {

    private T info;
    private NoLista proximo;

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T Info) {
        this.info = info;
    }

    public NoLista getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}
