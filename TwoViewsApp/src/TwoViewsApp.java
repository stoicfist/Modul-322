import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TwoViewsApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Erstelle das erste Fenster
            JFrame frame1 = createFirstView();
            frame1.setVisible(true);
        });
    }

    private static JFrame createFirstView() {
        // Fenster 1: Enthält ein Dreieck
        JFrame frame = new JFrame("Fenster 1 - Dreieck");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null); // Absolute Positionierung

        // Label hinzufügen
        JLabel label = new JLabel("Dies ist Fenster 1 mit einem Dreieck:");
        label.setBounds(10, 10, 300, 25);
        frame.add(label);

        // Dreieck zeichnen
        JPanel trianglePanel = new TrianglePanel();
        trianglePanel.setBounds(10, 50, 200, 200);
        frame.add(trianglePanel);

        // Button, um zum zweiten Fenster zu wechseln
        JButton button = new JButton("Zum Fenster 2 wechseln");
        button.setBounds(220, 200, 150, 25);
        frame.add(button);

        button.addActionListener((ActionEvent e) -> {
            frame.dispose(); // Schließe Fenster 1
            JFrame frame2 = createSecondView(); // Öffne Fenster 2
            frame2.setVisible(true);
        });

        return frame;
    }

    private static JFrame createSecondView() {
        // Fenster 2: Enthält einen Kreis
        JFrame frame = new JFrame("Fenster 2 - Kreis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null); // Absolute Positionierung

        // Label hinzufügen
        JLabel label = new JLabel("Dies ist Fenster 2 mit einem Kreis:");
        label.setBounds(10, 10, 300, 25);
        frame.add(label);

        // Kreis zeichnen
        JPanel circlePanel = new CirclePanel();
        circlePanel.setBounds(10, 50, 200, 200);
        frame.add(circlePanel);

        // Button, um zum ersten Fenster zurückzukehren
        JButton button = new JButton("Zurück zu Fenster 1");
        button.setBounds(220, 200, 150, 25);
        frame.add(button);

        button.addActionListener((ActionEvent e) -> {
            frame.dispose(); // Schließe Fenster 2
            JFrame frame1 = createFirstView(); // Öffne Fenster 1
            frame1.setVisible(true);
        });

        return frame;
    }

    // Panel, das ein Dreieck zeichnet
    static class TrianglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLUE);

            // Koordinaten des Dreiecks
            int[] xPoints = {50, 100, 0};
            int[] yPoints = {0, 100, 100};
            g2d.fillPolygon(xPoints, yPoints, 3);
        }
    }

    // Panel, das einen Kreis zeichnet
    static class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);

            // Kreis zeichnen
            g2d.fillOval(50, 50, 100, 100); // Position und Größe des Kreises
        }
    }
}
