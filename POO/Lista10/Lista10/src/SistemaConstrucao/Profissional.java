package SistemaConstrucao;

import java.util.List;

/**
 * Entidade que representa um profissional (Engenheiro, Arquiteto)..
 */
public class Profissional {
    private int id;
    private String cpf;
    private String nomeCompleto;
    private static int contador = 0;
    private static List<String> cpfsExistentes;

    public Profissional(int id, String cpf, String nomeCompleto) {
        contador++;
        this.id = contador;
        if (!(cpfExiste(cpf))) {
            this.cpf = cpf;
        }
        this.nomeCompleto = nomeCompleto;
        cpfsExistentes.add(cpf);
    }

    public boolean cpfExiste(String cpf) {
        return cpfsExistentes.contains(cpf);
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    @Override
    public String toString() {
        return "Profissional [ID=" + id + ", Nome=" + nomeCompleto + ", CPF=" + cpf + "]";
    }
}