import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // Atributos de la clase
    private String accountNumber = "123456789";
    private double balance = 1500.75;
    private int pin = 1234;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Main atm = new Main();
        System.out.println("Welcome to JavaBank ATM! Version control with Git.");

        // Uso de la calculadora
        Calculator calculator = new Calculator();
        calculator.start();

        // Operaciones con transacciones
        atm.deposit(500);
        atm.withdraw(100);

        System.out.println("Balance final: " + atm.balance);
        System.out.println("Historial de transacciones:");
        for (String transaction : atm.transactionHistory) {
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

    // Métodos para el array
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Fondos insuficientes.");
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

    // Clase Calculator
    public static class Calculator {

        private Scanner scanner = new Scanner(System.in);

        public void start() {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.print("Elija una operación (+, -, *, /): ");
            String operator = scanner.next();

            double result;
            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    try {
                        result = divide(num1, num2); // Intento de división
                        System.out.println("El resultado es: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Operador no válido.");
            }

            System.out.println("El resultado es: " + result);
        }

        public double add(double a, double b) {
            return a + b;
        }

        public double subtract(double a, double b) {
            return a - b;
        }

        public double multiply(double a, double b) {
            return a * b;
        }

        public double divide(double a, double b) {
            if (b != 0) {
                return a / b;
            } else {
                throw new ArithmeticException("No se puede dividir por cero");
            }
        }
    }
}