import javax.swing.JOptionPane;
public class Begruessung1 {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, 
				"Willkommen zur JAVA-Vorlesung, lieber Kursteilnehmer "+"\nMein erstes Programm: Hallo Welt!");
		JOptionPane.showMessageDialog(null, 
				"Willkommen zur JAVA-Vorlesung; 2. Begruessung");
		JOptionPane.showConfirmDialog(null, 
				"Willkommen zur JAVA-Vorlesung, 4 Begruessung");
		JOptionPane.showInputDialog(null);
		JOptionPane.showConfirmDialog(null, "Hello ^^", null, 0, 0);
		
		System.exit(0);

	}

}
