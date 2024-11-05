import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Opciones del ATM:");
        System.out.println("1. Ingresar");
        System.out.println("2. Salir");
        System.out.println("Selecciona una opción:");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option) {
            case 1:
                checkLogin();
                break;
            case 2:
                getOut();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void checkLogin() {
        Scanner cl = new Scanner(System.in);
        int attemps = 0;
        int pin = 1234;
        System.out.println("Intoduzca su pin: ");
        int userpin = cl.nextInt();
        while (attemps < 3) {
            if (pin == userpin) {
                System.out.println("\nBienvenido :)\n");
                Scanner as = new Scanner(System.in);
                System.out.println("Selecciona una opcion: ");
                System.out.println("1. Consultar cuenta");
                System.out.println("2. Depositar efectivo");
                System.out.println("3. Retirar efectivo");
                int secondList = as.nextInt();

                switch (secondList) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        depositMoney();
                        break;
                    case 3:
                        withdrawMoney();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } else {
                System.out.println("Error intoduzca su pin nuevamente: ");
                cl.nextInt();
            }
            attemps++;
        }
        System.out.println("Ha exedido el limite de intentos");
    }

    private static void getOut() {
        System.out.println("Adios");
    }

    private static void checkBalance() {
        System.out.println("Estamos trabajando en el proceso");

    }

    private static void depositMoney() {
        System.out.println("Estas trabajando en el proceso");
    }

    private static void withdrawMoney() {
        System.out.println("Solo billetes de 100");
    }
}