public class Medico {
    private String nome;
    private String crm;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public String exibirDados() {
        return toString();
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", crm=" + crm +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        if (crm.equals("")) {
            throw new IllegalArgumentException("crm não pode ser nulo");
        } else  this.crm = crm;

    }
}
