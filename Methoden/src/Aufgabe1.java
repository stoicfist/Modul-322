import java.util.Scanner;

public class Aufgabe1 {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter 1st Number: ");
		int a = num.nextInt();
		System.out.println("Enter 2cnd Number: ");
		int b = num.nextInt();
		num.close();

		int result = logic(a, b);
		if (result == 0) {
			System.out.println("a is equal to b");
		} else {
			System.out.println("The bigger number is: " + result);
		}
	}

	public static int logic(int a, int b) {
		if (a > b) {
			return a;

		} else if (a == b) {
			return 0;
		} else {
			return b;
		}

	}

}
