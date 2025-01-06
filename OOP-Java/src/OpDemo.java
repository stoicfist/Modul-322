
public class OpDemo {

	public static void main(String[] args) {
		int anzahl = 5;
		
		//1. Versuch: erst rechnen
		if (++anzahl == 6){
			System.out.println("Erst gerechnet: " + anzahl);
		} else {
			System.out.println("Erst verglichen: " + anzahl);
			
		}
		
		//2.Versuch
		anzahl = 5;
		if (anzahl == 6 ){
			System.out.println("Erst gerechnet: " + anzahl);
		}else {
			System.out.println("Erst verglichen: " + anzahl);
		}

	}

}
