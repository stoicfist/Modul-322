/**
 * Testklasse
 * @author Roger Zaugg
 * @version 1.0
 *
 */
public class Start {

	/**
	 * Startmethode
	 * @param args
	 */
	public static void main(String[] args) {
		
		Competition c = new Competition("Rotsee Regatta");
		
		Ship ship1 = new Ship(1, "Alinghi");
		Ship ship2 = new Ship(2, "Red Baron");
		Ship ship3 = new Ship(3, "Blue Lagoon");
		
		c.ship(ship1);
		c.ship(ship2);
		c.ship(ship3);
		
		c.start();
	
		c.printResult();
	}	
}