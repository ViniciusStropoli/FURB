import SistemaConstrucao.Profissional;
import SistemaConstrucao.Projeto;
import SistemaConstrucao.ProjetoPublico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class ProfissionalTest {


    @Test
    @DisplayName("Atribuir dados validos")
    public void criarProfTest() {
        Profissional p1 = new Profissional();
        p1.setCpf("12345678910");
        p1.setNomeCompleto("Joao Silva");
        assertEquals("12345678920", p1.getCpf());
        assertEquals("Joao Silva", p1.getNomeCompleto());
    }

    @Test
    @DisplayName("Atribuir dados nulos")
    public void criarProfNulo() {
        Profissional p1 = new Profissional();
        p1.setCpf(null);
        p1.setNomeCompleto("");
        assertNull(p1.getCpf());
        assertEquals("", p1.getNomeCompleto());
    }

    @Test
    @DisplayName("Adicionar projeto")
    public void criarProjeto() {
        Profissional p1 = new Profissional();
        Projeto prj = new ProjetoPublico(LocalDate.of(2025, Month.JANUARY, 10), "Construção da Ponte Central", LocalDate.of(2025, Month.MARCH, 1), LocalDate.of(2026, Month.MARCH, 1));
        p1.adicionarProjeto(prj);
        assertEquals(1, p1.getProjetos().size());
        assertTrue(p1.getProjetos().contains(prj));
    }


}
