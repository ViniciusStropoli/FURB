package SistemaConstrucao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe Abstrata Projeto.
 * Representa os atributos e comportamentos comuns a todos os tipos de projetos
 * (Públicos e Privados).
 */
public abstract class Projeto {
    private static int contador = 0;
    private int idProjeto;
    private LocalDate dataEntrada;
    private String descricao;
    private List<Profissional> responsaveis;

    public Projeto(LocalDate dataEntrada, String descricao) {
        contador++;
        this.idProjeto = contador;
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
        this.responsaveis = new ArrayList<>();
    }

    /**
     * Adiciona um profissional à lista de responsáveis pelo projeto.
     * @param profissional O profissional a ser adicionado.
     */
    public void adicionarResponsavel(Profissional profissional) {
        if (profissional != null && !this.responsaveis.contains(profissional)) {
            this.responsaveis.add(profissional);
        }
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Profissional> getResponsaveis() {
        return responsaveis;
    }

    public static void setContador(int contador) {
        Projeto.contador = contador;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResponsaveis(List<Profissional> responsaveis) {
        this.responsaveis = responsaveis;
    }

    /**
     * Método auxiliar para formatar a lista de responsáveis.
     */
    protected String getResponsaveisFormatado() {
        if (responsaveis.isEmpty()) {
            return "Nenhum responsável";
        }
        return responsaveis.stream().map(Profissional::getNomeCompleto).collect(Collectors.joining(", "));
    }

    /**
     * Método Abstrato.
     * Força as classes filhas a implementarem sua própria versão de resumo.
     * Usado pelo RelatorioResumido.
     * @return Uma string com o resumo formatado.
     */
    public abstract String getResumoFormatado();
}