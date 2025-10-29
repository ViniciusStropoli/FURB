package SistemaConstrucao;

import java.util.List;

/**
 * Interface RelatorioInterface (Contrato)
 * Define o contrato que todas as classes de relatório devem seguir.
 * Isso garante que o SistemaGerenciamento possa tratar todos os relatórios
 * de forma polimórfica.
 */
public interface RelatorioInterface {
    /**
     * Gera o conteúdo do relatório com base na lista de projetos fornecida.
     * @param projetos A lista de todos os projetos cadastrados.
     * @return Uma String formatada contendo o relatório.
     */
    String gerar(List<Projeto> projetos);
}