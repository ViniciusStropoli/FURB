import java.util.ArrayList;

public class Hospital {
    private String nome;
    private Endereco endereco;

    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Consulta> consultas;

    public Hospital(String nome) {
        this.nome = nome;
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public Consulta agendarConsulta(Consulta novaconsulta) {
        consultas.add(novaconsulta);
        return novaconsulta;
    }
    
    public void listarConsultas() {
        for (Consulta c : consultas) {
            System.out.println(c);
        }
    }

    public void cancelarConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void addPacientes(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void addMedicos(Medico medico) {
        medicos.add(medico);
    }
}
