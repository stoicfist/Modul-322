import java.util.Scanner;

public class EigeneBeispiel {

	public static void main(String[] args) {
		text();
		multiplication(5, 10);
		division(2, 2);
		squareroot(25);
		int test = subtraction(8, 10);
		System.out.println("Subtraction: " + test);

	}

	public static void text() {
		System.out.println("Test methods in Java:");
	}

	public static void multiplication(int a, int b) {
		System.out.println("Multiplikation: " + a + " * " + b + " = " + a * b);
	}

	public static void division(int a, int b) {
		System.out.println("Division: " + a + " : " + b + " = " + (double) a / (double) b);
	}

	public static void addition(int a, int b) {
		System.out.print("Addition: " + a + " + " + b + " = " + a + b);
	}

	public static int subtraction(int a, int b) {
		return a - b;
	}

	public static void squareroot(int a) {
		System.out.println("Squareroot: " + (double) Math.sqrt(a));
	}
}
