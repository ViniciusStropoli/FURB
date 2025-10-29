package SistemaConstrucao;


import java.time.LocalDate;

/**
 * Representa um Empreendimento Privado.
 * Herda de Projeto.
 */
public class EmpreendimentoPrivado extends Projeto {

    private String tipoArea;
    private double metragemTerreno;

    public EmpreendimentoPrivado(LocalDate dataEntrada, String descricao, String tipoArea, double metragemTerreno) {
        super(dataEntrada, descricao);
        this.tipoArea = tipoArea;
        this.metragemTerreno = metragemTerreno;
    }

    public EmpreendimentoPrivado(LocalDate dataEntrada, String descricao) {
        super(dataEntrada, descricao);
    }

    public String getTipoArea() {
        return tipoArea;
    }

    public double getMetragemTerreno() {
        return metragemTerreno;
    }

    public void setTipoArea(String tipoArea) {
        this.tipoArea = tipoArea;
    }

    public void setMetragemTerreno(double metragemTerreno) {
        this.metragemTerreno = metragemTerreno;
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
