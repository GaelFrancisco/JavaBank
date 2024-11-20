import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // Atributos de la clase
    private String accountNumber = "123456789";
    private double balance = 1500.75;
    private int pin = 1234;

    public static void main(String[] args) {
        Main atm = new Main();
        System.out.println("Welcome to JavaBank ATM! Version control with Git.");
        //uso de arrays
        double balance = 1000.0;
        ArrayList<String> transactionHistory = new ArrayList<>();

        deposit(500, balance, transactionHistory);
        withdraw(100, balance, transactionHistory);

        System.out.println("Balance final: " + balance);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }

        // Simulación de transacciones
        int[] transactionAmounts = {200, -100, 50};
        atm.processTransactions(transactionAmounts);

        // Estado de la cuenta
        String status = (atm.balance < 0) ? "Deuda" : "Crédito";
        System.out.println("Estado de cuenta: " + status);

        // Autenticación del usuario
        if (atm.authenticateUser("1234")) {
            System.out.println("Autenticación exitosa. Bienvenido al sistema.");
        } else {
            System.out.println("Autenticación fallida. Cuenta bloqueada.");
        }
    }

    //metodos para el array
    public static void deposit(double amount, double balance, ArrayList<String> transactionHistory) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public static boolean withdraw(double amount, double balance, ArrayList<String> transactionHistory) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    // Método para procesar transacciones
    public void processTransactions(int[] transactionAmounts) {
        for (int amount : transactionAmounts) {
            balance += amount;
        }
        balance++; // Incremento
        System.out.println("Balance actualizado: " + balance);
    }

    // Método para autenticar al usuario
    public boolean authenticateUser(String inputPin) {
        int attempts = 0;
        while (attempts < 3) {
            if (String.valueOf(this.pin).equals(inputPin)) {
                return true;
            } else {
                attempts++;
                System.out.println("PIN incorrecto. Intento " + attempts + " de 3.");
            }
        }
        return false;
    }
}

