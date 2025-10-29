package SistemaConstrucao;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        SistemaGerenciamento sistema = new SistemaGerenciamento();

        System.out.println("--- 1. CADASTRO DE PROFISSIONAIS ---");

        Profissional prof1 = new Profissional("111.111.111-11", "Ana Beatriz Silva");
        Profissional prof2 = new Profissional("222.222.222-22", "Carlos Eduardo Lima");
        Profissional prof3 = new Profissional("333.333.333-33", "Mariana Costa");

        sistema.cadastrarProfissional(prof1);
        sistema.cadastrarProfissional(prof2);
        sistema.cadastrarProfissional(prof3);

        System.out.println("\n--- 1.1 TESTE DE VALIDAÇÃO ---");
        Profissional prof5_duplicadoCPF = new Profissional("111.111.111-11", "Lucas Mendes");
        sistema.cadastrarProfissional(prof5_duplicadoCPF); // Deve falhar


        System.out.println("\n--- 2. CADASTRO DE PROJETOS ---");

        // Projeto Público 1
        Projeto proj1_publico = new ProjetoPublico(LocalDate.of(2025, Month.JANUARY, 10),
                "Construção da Ponte Central",
                LocalDate.of(2025, Month.MARCH, 1),
                LocalDate.of(2026, Month.MARCH, 1)
        );
        proj1_publico.adicionarResponsavel(prof1);
        proj1_publico.adicionarResponsavel(prof2);

        // Empreendimento Privado 1
        Projeto proj2_privado = new EmpreendimentoPrivado(LocalDate.of(2025, Month.FEBRUARY, 20),
                "Condomínio Residencial Green Valley",
                "Urbana", 15000.0
        );
        proj2_privado.adicionarResponsavel(prof2);

        // Projeto Público 2
        Projeto proj3_publico = new ProjetoPublico(LocalDate.of(2025, Month.MAY, 5),
                "Reforma Escola Municipal",
                LocalDate.of(2025, Month.JULY, 1),
                LocalDate.of(2025, Month.DECEMBER, 15)
        );
        proj3_publico.adicionarResponsavel(prof3);

        sistema.cadastrarProjeto(proj1_publico);
        sistema.cadastrarProjeto(proj2_privado);
        sistema.cadastrarProjeto(proj3_publico);

        System.out.println("\n--- 3. EMISSÃO DE RELATÓRIOS ---");

        //Relatório Completo
        RelatorioInterface relatorioCompleto = new RelatorioCompleto();
        System.out.println(sistema.emitirRelatorio(relatorioCompleto));

        //Relatório Resumido
        RelatorioInterface relatorioResumido = new RelatorioResumido();
        System.out.println(sistema.emitirRelatorio(relatorioResumido));

        //Relatórios Por Tipo
        RelatorioInterface relatorioPublicos = new RelatorioPorTipo("PUBLICO");
        System.out.println(sistema.emitirRelatorio(relatorioPublicos));

        RelatorioInterface relatorioPrivados = new RelatorioPorTipo("PRIVADO");
        System.out.println(sistema.emitirRelatorio(relatorioPrivados));

        //Relatório Por Profissional
        RelatorioInterface relatorioProfissional = new RelatorioPorProfissional(102);
        System.out.println(sistema.emitirRelatorio(relatorioProfissional));
    }
}