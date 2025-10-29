package SistemaConstrucao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal que orquestra o sistema.
 * Gerencia as listas de profissionais e projetos e emite relatórios.
 */
public class SistemaGerenciamento {
    private List<Projeto> projetos;
    private List<Profissional> profissionais;

    public SistemaGerenciamento() {
        this.projetos = new ArrayList<>();
        this.profissionais = new ArrayList<>();
    }

    /**
     * Cadastra um novo profissional, validando duplicidade.
     * @param profissional O profissional a ser cadastrado.
     */
    public void cadastrarProfissional(Profissional profissional) {
        for (Profissional p : profissionais) {
            if (p.getId() == profissional.getId()) {
                System.out.println("[FALHA CADASTRO] Erro: ID de profissional (" + profissional.getId() + ") já existe.");
                return;
            }
            if (p.getCpf().equals(profissional.getCpf())) {
                System.out.println("[FALHA CADASTRO] Erro: CPF (" + profissional.getCpf() + ") já cadastrado.");
                return;
            }
        }
        this.profissionais.add(profissional);
        System.out.println("[SUCESSO] Profissional cadastrado: " + profissional.getNomeCompleto());
    }

    /**
     * Cadastra um novo projeto (Público ou Privado), validando duplicidade.
     * @param projeto O projeto a ser cadastrado.
     */
    public void cadastrarProjeto(Projeto projeto) {
        for (Projeto p : projetos) {
            if (p.getIdProjeto() == projeto.getIdProjeto()) {
                System.out.println("[FALHA CADASTRO] Erro: ID de projeto (" + projeto.getIdProjeto() + ") já existe.");
                return;
            }
        }
        this.projetos.add(projeto);
        System.out.println("[SUCESSO] Projeto cadastrado: ID " + projeto.getIdProjeto());
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    /**
     * Emite um relatório. Este é o método polimórfico.
     * Ele não sabe qual relatório está sendo gerado, apenas que ele
     * implementa a interface RelatorioInterface.
     * @param relatorio A implementação concreta do relatório a ser gerado.
     * @return A string formatada do relatório.
     */
    public String emitirRelatorio(RelatorioInterface relatorio) {
        return relatorio.gerar(this.projetos);
    }
}