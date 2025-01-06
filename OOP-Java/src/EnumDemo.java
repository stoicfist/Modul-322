
public class EnumDemo {
	public enum Farbe {
		Rot, Grün, Blau, Schwarz
	};

	public static void main(String[] args) {
		Farbe meineLieblingsFarbe,
		      deineLieblingsFarbe;
		deineLieblingsFarbe = Farbe.Rot;
		
		//Zuweisung einer Variablen
		meineLieblingsFarbe = deineLieblingsFarbe;
		
		//Zuweisung andere Farbe
		meineLieblingsFarbe = Farbe.Rot;
		
		if(meineLieblingsFarbe == deineLieblingsFarbe) {
			System.out.println("Wir sollten heiraten!");
		}else {
			System.out.println("Wir passen nicht zusammen ...");
		}

	}

}
