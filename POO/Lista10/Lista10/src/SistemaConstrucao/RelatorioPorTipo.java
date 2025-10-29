package SistemaConstrucao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do Relatório por Tipo.
 * Filtra projetos por "PUBLICO" ou "PRIVADO".
 */
public class RelatorioPorTipo implements RelatorioInterface {
    private String tipo;

    public RelatorioPorTipo(String tipo) {
        this.tipo = tipo.toUpperCase();
    }

    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO POR TIPO: ").append(tipo).append(" ---\n");

        List<Projeto> projetosFiltrados;

        if ("PUBLICO".equals(tipo)) {
            projetosFiltrados = projetos.stream()
                    .filter(p -> p instanceof ProjetoPublico)
                    .collect(Collectors.toList());
        } else if ("PRIVADO".equals(tipo)) {
            projetosFiltrados = projetos.stream()
                    .filter(p -> p instanceof EmpreendimentoPrivado)
                    .collect(Collectors.toList());
        } else {
            sb.append("Tipo de relatório desconhecido: ").append(tipo).append("\n");
            return sb.toString();
        }

        if (projetosFiltrados.isEmpty()) {
            sb.append("Nenhum projeto encontrado para este tipo.\n");
            return sb.toString();
        }

        for (Projeto p : projetosFiltrados) {
            sb.append(p.getResumoFormatado()).append("\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
}