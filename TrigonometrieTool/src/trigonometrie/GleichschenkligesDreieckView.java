package trigonometrie;

import javax.swing.*;
import java.awt.*;

public class GleichschenkligesDreieckView {
    private JFrame frame;
    private JTextField basisField, seiteField, hoeheField, winkelAlphaField, winkelBetaField;

    public GleichschenkligesDreieckView() {
        frame = new JFrame("Gleichschenkliges Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 🔹 HEADER
        JLabel header = new JLabel("Gleichschenkliges Dreieck Berechnung", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(header, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // 🔹 Eingabefelder
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Basis (b):"), gbc);
        gbc.gridx = 1;
        basisField = new JTextField(10);
        frame.add(basisField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Seitenlänge (a):"), gbc);
        gbc.gridx = 1;
        seiteField = new JTextField(10);
        frame.add(seiteField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Höhe (h):"), gbc);
        gbc.gridx = 1;
        hoeheField = new JTextField(10);
        frame.add(hoeheField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(new JLabel("Winkel α (°):"), gbc);
        gbc.gridx = 1;
        winkelAlphaField = new JTextField(10);
        frame.add(winkelAlphaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(new JLabel("Winkel β (°):"), gbc);
        gbc.gridx = 1;
        winkelBetaField = new JTextField(10);
        frame.add(winkelBetaField, gbc);

        // 🔹 Button-Panel
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Berechnen");
        JButton backButton = new JButton("Zurück");
        backButton.addActionListener(e -> frame.dispose());
        buttonPanel.add(calculateButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonPanel, gbc);

        // 🔹 Fußzeile
        JLabel footer = new JLabel("Gib mindestens 2 Werte ein (z. B. 2 Seiten oder 1 Seite & 1 Winkel).", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        frame.add(footer, gbc);

        // 🔹 Berechnungslogik mit Mindestprüfung
        calculateButton.addActionListener(e -> {
            try {
                Double b = getValue(basisField);
                Double a = getValue(seiteField);
                Double h = getValue(hoeheField);
                Double alpha = getValue(winkelAlphaField);
                Double beta = getValue(winkelBetaField);

                // 🔹 Prüfe Mindestanzahl der Eingaben
                int anzahlEingaben = 0;
                if (b != null) anzahlEingaben++;
                if (a != null) anzahlEingaben++;
                if (h != null) anzahlEingaben++;
                if (alpha != null) anzahlEingaben++;
                if (beta != null) anzahlEingaben++;

                if (anzahlEingaben < 2) {
                    JOptionPane.showMessageDialog(frame, "Bitte gib mindestens 2 Werte ein!\n"
                            + "Erlaubt: 2 Seiten oder 1 Seite & 1 Winkel.", "Fehler", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 🔹 Berechnung mit Basis und Winkel β
                if (b != null && beta != null) {
                    alpha = 90 - beta; // Ergänzungswinkel
                    h = (b / 2) * Math.tan(Math.toRadians(alpha));
                    a = Math.sqrt(h * h + (b / 2) * (b / 2));
                }

                // 🔹 Berechnung mit Seitenlänge `a` und Winkel `α`
                if (a != null && alpha != null) {
                    beta = 180 - (2 * alpha); // Ergänzungswinkel
                    b = 2 * (a * Math.cos(Math.toRadians(alpha))); // Basis berechnen
                    h = a * Math.sin(Math.toRadians(alpha)); // Höhe berechnen
                }

                // 🔹 Berechnung mit Basis und Höhe
                if (b != null && h != null && a == null) {
                    a = Math.sqrt(h * h + (b / 2) * (b / 2)); // Seitenlänge über Pythagoras
                }

                // 🔹 Berechnung der Höhe über Seitenlänge
                if (a != null && h == null) {
                    h = Math.sqrt(a * a - (b / 2) * (b / 2)); // Höhe über Pythagoras
                }

                // 🔹 Überprüfen, ob alles berechnet wurde
                if (b == null || a == null || h == null || alpha == null || beta == null) {
                    JOptionPane.showMessageDialog(frame, "Berechnung unvollständig! Bitte überprüfe die Eingaben.", "Fehler", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                new ErgebnisFenster("Gleichschenkliges Dreieck\n\n"
                        + "Basis (b): " + round(b) + "\n"
                        + "Seitenlänge (a): " + round(a) + "\n"
                        + "Höhe (h): " + round(h) + "\n"
                        + "Winkel α: " + round(alpha) + "°\n"
                        + "Winkel β: " + round(beta) + "°");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Bitte gültige Zahlen eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    // 🔹 Hilfsmethode, um Werte aus Textfeldern zu holen
    private Double getValue(JTextField field) {
        String text = field.getText();
        return text.isEmpty() ? null : Double.parseDouble(text);
    }

    // 🔹 Werte auf 2 Nachkommastellen runden
    private String round(double value) {
        return String.format("%.2f", value);
    }
}
