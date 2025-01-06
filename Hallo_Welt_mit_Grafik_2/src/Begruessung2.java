import javax.swing.JOptionPane;
public class Begruessung2 {

	public static void main(String[] args) {
		if(null ==args || args.length<1) {
			JOptionPane.showMessageDialog(null, 
			"Willkommen zur JAVA-Vorlesung, lieber Kursteilnehmer "+
			"\nMein erstes Programm: Hallo Welt!");
		} else {
			JOptionPane.showMessageDialog(null, 
			"Willkommen zur JAVA-Vorlesung, lieber Kursteilnehmer "+args[0]+
			"\nMein erstes Programm: Hallo Welt!");
		}
		System.exit(0);
	}

}

/* 
 a) Ohne Argumment das Obere; Mit Argument das untere.
 b) Das \n steht für newline; Abstand nach \n bedeutet Abstand nach newline
 c) "Willkommen zur JAVA-Vorlesung,\nlieber Kursteilnehmer "+
			"\nMein erstes Programm: Hallo Welt!"
 */