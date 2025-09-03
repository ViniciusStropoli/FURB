package ClinicaVet;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Cadastro de Tutores ===");

        try {
            Tutor t1 = new Tutor("Carlos Silva", "11999999999", "Rua das Flores, 123");
            Tutor t2 = new Tutor("Ana Souza", "11888888888");
            Tutor t3 = new Tutor("João SemTelefone", ""); // Deve lançar exceção

            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar tutor: " + e.getMessage());
        }

        System.out.println("\n=== Cadastro de Animais ===");

        try {
            Animal a1 = new Animal("Bidu", "Cachorro", 5, "Consulta inicial.");
            Animal a2 = new Animal("Mimi", "Gato", 3, "Vacinação.");
            Animal a3 = new Animal("Tartaruguinha", "Tartaruga", -1, "Raio-X"); // Deve lançar exceção

            a1.adicionarHistorico("Banho e tosa.");
            a2.adicionarHistorico("Cirurgia de castração.");

            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar animal: " + e.getMessage());
        }

    }
}
