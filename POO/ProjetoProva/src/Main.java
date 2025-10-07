import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        Hospital h1 = new Hospital("Santo Antônio");
        Endereco e1 = new Endereco("Rua Alvin Shrader", 151, "Blumenau");

        Paciente p1 = new Paciente("José", "123.456.789-10", 24);
        Paciente p2 = new Paciente("Joao", "987.654.321-01", 74);
        Paciente p3 = new Paciente("Maria", "937.674.121-21", 45);


        Medico m1 = new Medico("Paulo", "100001");
        Medico m2 = new Medico("Fábio", "100002");
        Medico m3 = new Medico("Fernanda", "100003");
        Medico m4 = new Medico("Fernando", "100004");
        Medico m5 = new Medico("Camilo", "100005");

        Consulta c1 = new Consulta(p1, m1, LocalDate.of(2025, 10, 15), "O paciente está muito mal!");
        Consulta c2 = new Consulta(p2, m2, LocalDate.of(2025, 10,16), "O paciente está muito bem!");
        Consulta c3 = new Consulta(p3, m3, LocalDate.of(2025, 10,17), "O paciente está medianamente bem!");
        Consulta c4 = new Consulta(p3, m4, LocalDate.of(2025, 10,18), "O paciente está medianamente mal!");

        h1.agendarConsulta(c1);
        h1.agendarConsulta(c2);
        h1.agendarConsulta(c3);
        h1.agendarConsulta(c4);

        h1.addEndereco(e1);
        h1.addPacientes(p1);
        h1.addPacientes(p2);
        h1.addPacientes(p3);
        h1.addMedicos(m1);
        h1.addMedicos(m2);
        h1.addMedicos(m3);
        h1.addMedicos(m4);
        h1.addMedicos(m5);

        h1.listarConsultas();

        h1.cancelarConsulta(c2);

    }
}
