package pilha;

public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int limite;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public PilhaVetor(int limite) {
        this.limite = limite;
        this.tamanho = 0;
        this.info = (T[]) new Object[limite];
    }

    @Override
    public void push(T valor) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        tamanho--;
        return info[tamanho];
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = tamanho - 1; i >= 0; i--) {
            sb.append(info[i]);
            if (i > 0) sb.append(",");
        }
        return sb.toString();
    }

    public void concatenar(PilhaVetor<T> p) {
        PilhaVetor<T> aux = new PilhaVetor<>(p.limite);

        // inverter p
        while (!p.estaVazia()) {
            aux.push(p.pop());
        }

        // adicionar mantendo ordem
        while (!aux.estaVazia()) {
            T valor = aux.pop();

            if (this.tamanho == this.limite) {
                throw new PilhaCheiaException();
            }

            this.push(valor);
            p.push(valor); // restaura p
        }
    }
}