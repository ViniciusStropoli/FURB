import java.time.LocalDate;

public class Consulta {
    private final Medico medico;
    private final Paciente paciente;
    private LocalDate data;
    private String observacoes;

    public Consulta(Paciente paciente, Medico medico, LocalDate data, String observacoes) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.observacoes = observacoes;
    }

    public void adicionarObservacoes(String observacoes) {
        this.observacoes += "\n" + observacoes;
    }

    public String exibirDados() {
        return toString();
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data=" + data +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
