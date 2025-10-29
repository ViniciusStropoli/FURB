package SistemaConstrucao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa um Projeto Público.
 * Herda de Projeto.
 */
public class ProjetoPublico extends Projeto {

    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public ProjetoPublico(LocalDate dataEntrada, String descricao, LocalDate dataInicio, LocalDate dataTermino) {
        super(dataEntrada, descricao);
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public ProjetoPublico(LocalDate dataEntrada, String descricao) {
        super(dataEntrada, descricao);
    }

    /**
     * Calcula a duração do projeto em dias.
     * @return O número de dias entre o início e o término.
     */
    public long calcularDuracaoEmDias() {
        if (dataInicio == null || dataTermino == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(dataInicio, dataTermino);
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * Implementação do método abstrato.
     * Fornece o resumo específico para um projeto público.
     */
    @Override
    public String getResumoFormatado() {
        return String.format(
                "[PÚBLICO] ID %d: %s (Duração: %d dias)",
                getIdProjeto(),
                getDescricao(),
                calcularDuracaoEmDias()
        );
    }
}
