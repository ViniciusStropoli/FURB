import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Projeto {
    private int id;
    private LocalDate dataEntrou;
    private String descricao;
    private LocalDate dataComeco;
    private LocalDate dataFinal;
    private static ArrayList<Profissional> responsaveis;
    private String tempoDuracao;

    public Projeto(int id, LocalDate dataEntrou, String descricao, LocalDate dataComeco, LocalDate dataFinal, String tempoDuracao) {
        this.id = id;
        this.dataEntrou = dataEntrou;
        this.descricao = descricao;
        this.dataComeco = dataComeco;
        this.dataFinal = dataFinal;
        this.tempoDuracao = tempoDuracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrou() {
        return dataEntrou;
    }

    public void setDataEntrou(LocalDate dataEntrou) {
        this.dataEntrou = dataEntrou;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataComeco() {
        return dataComeco;
    }

    public void setDataComeco(LocalDate dataComeco) {
        this.dataComeco = dataComeco;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public static ArrayList<Profissional> getResponsaveis() {
        return responsaveis;
    }

    public static void setResponsaveis(ArrayList<Profissional> responsaveis) {
        Projeto.responsaveis = responsaveis;
    }

    public String getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(String tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }
}
