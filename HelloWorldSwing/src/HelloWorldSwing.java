import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloWorldSwing {
    public static void main(String[] args) {
        // Starten Sie die Swing-Komponenten im Event-Dispatch-Thread
        SwingUtilities.invokeLater(() -> {
            // Erstellen eines Fensters
            JFrame frame = new JFrame("Hello World Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200); // Größe des Fensters

            // Erstellen eines Labels
            JLabel label = new JLabel("Hello, World!", JLabel.CENTER);
            frame.add(label); // Hinzufügen des Labels zum Fenster

            // Fenster sichtbar machen
            frame.setVisible(true);
        });
    }
}
