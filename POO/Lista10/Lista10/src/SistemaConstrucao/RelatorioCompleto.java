package SistemaConstrucao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do Relatório Completo.
 * Lista todos os projetos, ordenados por número.
 */
public class RelatorioCompleto implements RelatorioInterface {
    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO COMPLETO (Ordenado por ID) ---\n");

        if (projetos.isEmpty()) {
            sb.append("Nenhum projeto cadastrado.\n");
            return sb.toString();
        }

        List<Projeto> projetosOrdenados = projetos.stream()
                .sorted(Comparator.comparing(Projeto::getIdProjeto))
                .collect(Collectors.toList());

        for (Projeto p : projetosOrdenados) {
            sb.append("------------------------------------------\n");
            sb.append(p.getResumoFormatado()).append("\n");
            sb.append("  Data Entrada: ").append(p.getDataEntrada()).append("\n");
            sb.append("  Responsáveis: ").append(p.getResponsaveisFormatado()).append("\n");

            if (p instanceof ProjetoPublico) {
                ProjetoPublico pp = (ProjetoPublico) p;
                sb.append("  Data Início: ").append(pp.getDataInicio()).append("\n");
                sb.append("  Data Término: ").append(pp.getDataTermino()).append("\n");
            } else if (p instanceof EmpreendimentoPrivado) {
                EmpreendimentoPrivado ep = (EmpreendimentoPrivado) p;
                sb.append("  Tipo Área: ").append(ep.getTipoArea()).append("\n");
                sb.append("  Metragem: ").append(ep.getMetragemTerreno()).append(" m²\n");
            }
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
}