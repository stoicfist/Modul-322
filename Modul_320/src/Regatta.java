
public class Regatta {

	public static void main(String[] args) {
		Competition  c = new Competition("Rotsee Regatta");

		Ship ship1 = new Ship(1, "Alinghi");
		Ship ship2 = new Ship(2, "Red Baron");
		Ship ship3 = new Ship(3, "Blue Lagoon");
		
		c.ship(ship1); // add ships to competition
		c.ship(ship2);
		c.ship(ship3);
		
		c.start(); // start competition
		c.printResult(); //prints ships with time
		
	}

}
