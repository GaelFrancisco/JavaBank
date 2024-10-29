public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, JavaBank ATM version control with Git");
        ///
        String accountNumber = "123456789";
        double balance = 1500.75;
        int pin = 12345;

        // Array de montos de transacciones
        int[] transactionAmounts = {200, -100, 50};

        // Operaciones con variables
        balance += transactionAmounts[0]; // Depósito
        if (balance > 0 && pin == 12345) {
            System.out.println("Acceso Concedido");
        }

        // Uso de operadores
        balance++; // Incremento
        String status = (balance < 0) ? "Deuda" : "Crédito";
        System.out.println("Estado de cuenta: " + status);
    }
}