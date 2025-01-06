import java.util.Scanner;

public class Arbeitsblatt_AccountApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        System.out.println("Welcome to the account application");

        while (true) {
            System.out.println("Please enter the amount:");
            double amount = scanner.nextDouble();

            System.out.println("Enter '+' to credit the account, '-' to debit the account, or '0' to terminate:");
            char operation = scanner.next().charAt(0); // Liest das erste Zeichen des vom Benutzer eingegebenen Strings

            switch (operation) {
                case '+':
                    balance += amount;
                    break;
                case '-':
                    balance -= amount;
                    break;
                case '0':
                    // Terminate the program if '0' is entered as the operation
                    System.out.println("Program terminated. Final balance: " + balance);
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid operation. Please enter '+' to credit, '-' to debit, or '0' to terminate.");
                    continue; // If invalid input, prompt again
            }

            System.out.println("Current balance: " + balance);
        }
    }
}

