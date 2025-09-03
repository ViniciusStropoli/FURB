package ClinicaVet;

/**
 * Representa um tutor de animais da clínica veterinária.
 */
public class Tutor {
    private String nome;
    private String telefone;
    private String endereco;

    /**
     * Construtor completo.
     *
     * @param nome     Nome do tutor
     * @param telefone Telefone do tutor (não pode ser vazio)
     * @param endereco Endereço do tutor
     * @throws IllegalArgumentException se o telefone estiver vazio
     */
    public Tutor(String nome, String telefone, String endereco) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório.");
        }
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
     * Construtor básico.
     *
     * @param nome     Nome do tutor
     * @param telefone Telefone do tutor
     */
    public Tutor(String nome, String telefone) {
        this(nome, telefone, "");
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório.");
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
