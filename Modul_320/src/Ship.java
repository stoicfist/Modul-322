import java.util.Random;

/**
 * Bietet Funktionen eines Schiffs an
 * @author Roger Zaugg
 * @version 1.0
 *
 */
public class Ship {

	private int nr;
	private String name;
	private int time;

	public Ship(int nr, String name) {
		this.nr = nr;
		this.name = name;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/**
	 * 
	 * @return Name des Schiffs
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setzt den Namen des Schiffs neu
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Führt das Rennen durch und berechnet die Rennzeit.
	 * Speichert dieses Ergebnis in time
	 */
	public void race() {
		int min = 300;
		int max = 600;
		this.time = (int) (Math.random() * (max - min + 1)) + min;
	}
	
	/**
	 * Gibt die Rennzeit des Schiffs zurück
	 * @return
	 */
	public int getTime() {
		return time;
	}
	
}