public class Paciente {
    private String nome;
    private String cpf;
    private int idade;

    public Paciente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String exibirDados() {
        return toString();
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.equals("")) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }else this.cpf = cpf;

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
