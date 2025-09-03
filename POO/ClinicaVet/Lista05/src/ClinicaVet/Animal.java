package ClinicaVet;

/**
 * Representa um animal cadastrado na clínica veterinária.
 */
public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private String historico;

    /**
     * Construtor completo.
     *
     * @param nome     Nome do animal
     * @param especie  Espécie do animal
     * @param idade    Idade do animal (não pode ser negativa)
     * @param historico Histórico inicial do animal
     * @throws IllegalArgumentException se a idade for negativa
     */
    public Animal(String nome, String especie, int idade, String historico) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.historico = historico;
    }

    /**
     * Construtor com dados básicos.
     *
     * @param nome    Nome do animal
     * @param especie Espécie do animal
     */
    public Animal(String nome, String especie) {
        this(nome, especie, 0, "");
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do animal.
     *
     * @param idade Idade (deve ser >= 0)
     * @throws IllegalArgumentException se a idade for negativa
     */
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * Adiciona uma nova entrada ao histórico do animal.
     *
     * @param descricao Descrição do histórico
     */
    public void adicionarHistorico(String descricao) {
        historico += descricao + "\n";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", idade=" + idade +
                ", historico='" + historico + '\'' +
                '}';
    }
}

