import java.util.Scanner;

public class Aufgabe2 {

	public static void main(String[] args) {
		System.out.println("Zahl eingeben: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		sc.close();

		int a = 0;
		do {
			System.out.println(a + "*" + i + "=" + a * i);
			a = a + 1; //man kann auch a++; verwenden
		}while (a <= 15);

	}

}
