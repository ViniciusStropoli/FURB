package Exe01;

public class ListaEstaticaGenerica<T> {
    private T[] info;
    private int tamanho;

    public ListaEstaticaGenerica() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        T[] novoInfo = (T[]) new Object[this.info.length + 10];
        for (int i = 0; i < this.info.length; i++) {
            novoInfo[i] = this.info[i];
        }
        this.info = novoInfo;
    }

    public void inserir(T valor) {
        if (this.tamanho == this.info.length) {
            redimensionar();
        }
        this.info[this.tamanho] = valor;
        this.tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.info[i]);
        }
    }

    public int buscar(T valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if (posicao != -1) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.info[i] = this.info[i + 1];
            }
            this.tamanho--;
        }
    }

    public void liberar() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return this.info[posicao];
    }

    public void inverter() {
        int ultimo = this.tamanho -1;

        for (int i = 0; i < this.tamanho/2; i++) {
            T intermediaria = this.info[i];
            this.info[i] = this.info[ultimo];
            this.info[ultimo] = intermediaria;
            ultimo--;
        }
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.tamanho; i++) {
            sb.append(this.info[i]);
            if (i < this.tamanho - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}