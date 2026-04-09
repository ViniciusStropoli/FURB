package Exe01;

public class ListaEncadeada<T> {

    private NoLista primeiro;

    public ListaEncadeada() {
        super();
    }

    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T valor) {
        NoLista novo = new NoLista<T>();
        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        if (primeiro != null) {
            return false;
        }
        return true;
    }

    public NoLista<T> buscar(T valor) {
        if (primeiro != null) {
            NoLista<T> p = primeiro;
            while (p != null) {
                if (p.getInfo() == valor) {
                    return p;
                }
                p = p.getProximo();
            }
        }
        return null;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && p.getInfo() != valor) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int tamanho = 0;

        if (primeiro != null) {
            NoLista<T> p = primeiro;
            while (p != null) {
                tamanho++;
                p = p.getProximo();
            }
        }

        return tamanho;
    }

    public NoLista<T> obterNo(int index) {
        int contador = 0;
        if (primeiro != null) {
            NoLista<T> p = primeiro;
            do {
                p.getProximo();
                contador++;
            } while (p != null || contador == index);

            return p;
        }

        return null;
    }

    @Override
    public String toString() {
        String resultado = "";
        NoLista<T> p = primeiro;

        while (p != null) {
            resultado += p.getInfo().toString();

            if (p.getProximo() != null) {
                resultado += " -> ";
            }

            p = p.getProximo();
        }

        return resultado;
    }
}
