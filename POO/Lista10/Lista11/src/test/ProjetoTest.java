import static org.junit.jupiter.api.Assertions.*;

import SistemaConstrucao.EmpreendimentoPrivado;
import SistemaConstrucao.Profissional;
import SistemaConstrucao.ProjetoPublico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ProjetoTest {
    @Test
    @DisplayName("Criação Válida e Duração")
    void testCriacaoValidaEDuracao() {
        ProjetoPublico p = new ProjetoPublico(LocalDate.of(2023, 1, 1), "projeto");
        p.setDataInicio(LocalDate.of(2023, 1, 1));
        p.setDataTermino(LocalDate.of(2023, 1, 31));

        assertTrue(p.getResumoFormatado().contains("30"), "Resumo deve conter '30 dias'");
    }


    @Test
    @DisplayName("Adicionar Responsável Duplicado (Exceção)")
    void testAdicionarResponsavelDuplicado() {
        ProjetoPublico p = new ProjetoPublico(LocalDate.of(2023, 1, 1), "projeto");

        Profissional prof = new Profissional();
        prof.setCpf("111");

        p.adicionarResponsavel(prof);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            p.adicionarResponsavel(prof);
        }, "Deve lançar exceção ao adicionar responsável duplicado");

        assertTrue(thrown.getMessage().contains("Profissional já registrado para o projeto: 102"));
    }


    @Test
    @DisplayName("Criação Válida e Resumo")
    void testCriacaoValidaEResumo() {
        EmpreendimentoPrivado p = new EmpreendimentoPrivado(LocalDate.of(2023, 1, 1), "projeto");
        p.setTipoArea("RESIDENCIAL");
        p.setMetragemTerreno(150.5);

        assertEquals(150.5, p.getMetragemTerreno(), 0.001, "Metragem deve ser 150.5");
        assertTrue(p.getResumoFormatado().contains("RESIDENCIAL"), "Resumo deve conter 'RESIDENCIAL'");
        assertTrue(p.getResumoFormatado().contains("150.5"), "Resumo deve conter '150.5 m²'");
    }


    @Test
    @DisplayName("Metragem Inválida")
    void testMetragemInvalida() {
        EmpreendimentoPrivado p = new EmpreendimentoPrivado(LocalDate.of(2023, 1, 1), "projeto");
        p.setMetragemTerreno(-10);

        assertEquals(-10, p.getMetragemTerreno(), "Confirma ausência de validação para metragem negativa");
    }
}
