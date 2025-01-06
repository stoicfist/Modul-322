import java.util.Scanner;
public class GutenMorgen {
	public static void main(String[] args) {
		System.out.println("Bitte Name eingeben: ");
		
		Scanner eingabe = new Scanner(System.in);
		String name = eingabe.nextLine();
		
		System.out.println("\nGuten Morgen " + name + "!");

	}

}
