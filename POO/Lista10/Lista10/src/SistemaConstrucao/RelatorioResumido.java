package SistemaConstrucao;

import java.util.List;

/**
 * Implementação do Relatório Resumido.
 * Exibe apenas as informações essenciais usando o método polimórfico.
 */
public class RelatorioResumido implements RelatorioInterface {
    @Override
    public String gerar(List<Projeto> projetos) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO RESUMIDO ---\n");

        if (projetos.isEmpty()) {
            sb.append("Nenhum projeto cadastrado.\n");
            return sb.toString();
        }

        for (Projeto p : projetos) {
            sb.append(p.getResumoFormatado()).append("\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
}