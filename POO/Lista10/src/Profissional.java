import java.util.List;

public class Profissional {
    private int id;
    private String nome;
    private String cpf;
    private static int contador = 1;
    private static List<String> cpfExistem;

    public Profissional(int id, String nome, String cpf) {
        this.id = contador;
        this.nome = nome;
        if (validateCpf(cpf)) {
            throw new IllegalArgumentException("Esse CPF já foi cadastrado :" + cpf );
        }
        this.cpf = cpf;
        contador++;
        cpfExistem.add(cpf);
    }

    public boolean validateCpf(String cpf) {
        return cpfExistem.contains(cpf);
    }

    public int getId() {
        return id;
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
        this.cpf = cpf;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Profissional.contador = contador;
    }
}
