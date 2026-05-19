public class FilaVetor<T> implements Fila<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException("Fila cheia");
        }
        int pos = (inicio + tamanho) % limite;
        info[pos] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia");
        }
        return (T) info[inicio];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia");
        }
        T valor = (T) info[inicio];
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    public int getLimite() {
        return limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.tamanho + f2.tamanho);

        // copia f1 (this)
        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.limite;
            f3.inserir((T) this.info[pos]);
        }

        // copia f2
        for (int i = 0; i < f2.tamanho; i++) {
            int pos = (f2.inicio + i) % f2.limite;
            f3.inserir((T) f2.info[pos]);
        }

        return f3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Fila: [");
        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % limite;
            sb.append(info[pos]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}