import java.util.Scanner;
import java.util.ArrayList;

// Clase base para cuentas
class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

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

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        System.out.println("Historial de transacciones:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Clase específica para cuentas de ahorro
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Intereses aplicados: $" + interest);
    }
}

// Clase principal
public class Main extends Account {
    private int pin;

    public Main(String accountNumber, double initialBalance, int pin) {
        super(accountNumber, initialBalance);
        this.pin = pin;
    }

    public static void main(String[] args) {
        Main mainAccount = new Main("123456789", 1500.75, 1234);
        System.out.println("Welcome to JavaBank ATM! Version control with Git.");

        // Uso de la calculadora
        Calculator calculator = new Calculator();
        calculator.start();

        // Operaciones en la cuenta principal
        mainAccount.deposit(500);
        mainAccount.withdraw(100);

        System.out.println("Balance final: $" + mainAccount.getBalance());
        mainAccount.showTransactionHistory();

        // Cuentas de ahorro
        SavingsAccount savingsAccount = new SavingsAccount("987654321", 2000.0, 0.05);
        savingsAccount.applyInterest();
        System.out.println("Balance de cuenta de ahorro después de intereses: $" + savingsAccount.getBalance());
        savingsAccount.showTransactionHistory();
    }

    // Clase Calculator
    public static class Calculator {
        private Scanner scanner = new Scanner(System.in);

        public void start() {
            try {
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
                            result = divide(num1, num2);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                            return;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no válido.");
                }
                System.out.println("El resultado calculadora es: " + result);
            } finally {
                scanner.close();
            }
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