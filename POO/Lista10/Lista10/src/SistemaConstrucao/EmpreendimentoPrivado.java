package SistemaConstrucao;


import java.time.LocalDate;

/**
 * Representa um Empreendimento Privado.
 * Herda de Projeto.
 */
public class EmpreendimentoPrivado extends Projeto {

    private String tipoArea;
    private double metragemTerreno;

    public EmpreendimentoPrivado(int idProjeto, LocalDate dataEntrada, String descricao, String tipoArea, double metragemTerreno) {
        super(idProjeto, dataEntrada, descricao);
        this.tipoArea = tipoArea;
        this.metragemTerreno = metragemTerreno;
    }

    public String getTipoArea() {
        return tipoArea;
    }

    public double getMetragemTerreno() {
        return metragemTerreno;
    }

    /**
     * Implementação do método abstrato.
     * Fornece o resumo específico para um empreendimento privado.
     */
    @Override
    public String getResumoFormatado() {
        return String.format(
                "[PRIVADO] ID %d: %s (Local: %s, Área: %.2f m²)",
                getIdProjeto(),
                getDescricao(),
                tipoArea,
                metragemTerreno
        );
    }
}
