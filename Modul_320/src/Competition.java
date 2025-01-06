import java.util.ArrayList;

/**
 * Klasse, um Wettkämpfe mit Schiffen zu absolvieren
 * 
 * @author Roger Zaugg
 * @version 1.0
 *
 */
public class Competition {

	private String name;
	//private Ship[] ships = new Ship[5];
	ArrayList<Ship> ships = new ArrayList<Ship>();

	/**
	 * Erstellt ein neues Wettkampf Objekt
	 * 
	 * @param name Name des Wettkampfs
	 */
	public Competition(String name) {
		this.name = name;
	}

	/**
	 * Startet den Wettkampf.
	 * 
	 * @see Ship#race()
	 */
	public void start() {

		for (Ship s : this.ships) {
			if (s != null) {
				s.race();
			}
		}

		// Alternative:
		/*
		 * for (int i = 0; i < ships.length; i++) { 
		 * 	if (ships[i] != null) { 
		 * 		Ship s = ships[i]; 
		 * 		s.race(); 
		 *  }
		 * }
		 */
	}

	/**
	 * Fügt ein Schiff zum Wettkampf hinzu, sofern noch nicht alle Plätze belegt
	 * sind.
	 * 
	 * @param s Ship
	 */
	
	//nicht nötig da ArrayList dynamisch ist
/*	public void ship(Ship ship) {
		for (int i = 0; i < ships.length; i++) {
			if (ships[i] == null) {
				ships[i] = ship;
				break;
			}
		}
	}
*/
	public void ship(Ship ship) {
	ships.add(ship);
	}
	/**
	 * Gibt alle Schiffe des Wettkampfs auf die Konsole aus
	 */
	public void printResult() {
		System.out.println("Wettkampf: " + this.name);

		for (Ship s : this.ships) {
			if (s != null) {
				System.out.println("Schiff Nr: " + s.getNr() + " Name: " + s.getName() + " Zeit: " + s.getTime());
			}
		}
	}
}