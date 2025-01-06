
public class BoolDemo {

	public static void main(String[] args) {
		int alter = 16;
		boolean hatFührerschein = true;
		boolean darfFahren = (alter == 18 && hatFührerschein);

		System.out.println("Hat führerschein, aber " + "erst " + alter + "? " + "Darf fahren: " + darfFahren);

	}

}
