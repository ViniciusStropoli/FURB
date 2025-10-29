package SistemaConstrucao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do Relatório por Profissional[cite: 53].
 * Lista todos os projetos de um profissional específico (pelo ID).
 */
public class RelatorioPorProfissional implements RelatorioInterface {
    private int idProfissional;

    public RelatorioPorProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO POR PROFISSIONAL (ID: ").append(idProfissional).append(") ---\n");

        List<Projeto> projetosFiltrados = projetos.stream()
                .filter(projeto -> projeto.getResponsaveis().stream()
                        .anyMatch(prof -> prof.getId() == idProfissional))
                .collect(Collectors.toList());

        if (projetosFiltrados.isEmpty()) {
            sb.append("Nenhum projeto encontrado para este profissional.\n");
            return sb.toString();
        }

        for (Projeto p : projetosFiltrados) {
            sb.append(p.getResumoFormatado()).append("\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
}