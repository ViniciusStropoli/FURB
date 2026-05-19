package ListaEncadeadaDupla;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);

        if (primeiro == null) {
            primeiro = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> no = buscar(valor);

        if (no == null) return;

        if (no.getAnterior() == null) {
            // remover primeiro
            primeiro = no.getProximo();
            if (primeiro != null) {
                primeiro.setAnterior(null);
            }
        } else {
            no.getAnterior().setProximo(no.getProximo());

            if (no.getProximo() != null) {
                no.getProximo().setAnterior(no.getAnterior());
            }
        }
    }

    public void exibirOrdem() {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
            atual = proximo;
        }

        primeiro = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }

        return sb.toString();
    }
}