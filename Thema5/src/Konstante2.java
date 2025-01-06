import java.util.Scanner;

public class Konstante2 {

	public static void main(String[] args) {
		System.out.println("Gib eine Zahl ein");
		Scanner sc = new Scanner(System.in);
		double i = sc.nextDouble();
		sc.close();
		System.out.println(Konstanten.MWST * i);

	}

}
