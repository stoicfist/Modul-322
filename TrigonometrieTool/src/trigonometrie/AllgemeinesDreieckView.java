package trigonometrie;

import javax.swing.*;
import java.awt.*;

public class AllgemeinesDreieckView {
    private JFrame frame;
    private JTextField seiteAField, seiteBField, seiteCField, winkelAlphaField, winkelBetaField, winkelGammaField;

    public AllgemeinesDreieckView() {
        frame = new JFrame("Allgemeines Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 🔹 HEADER
        JLabel header = new JLabel("Allgemeines Dreieck Berechnung", SwingConstants.CENTER);
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
        frame.add(new JLabel("Seite a:"), gbc);
        gbc.gridx = 1;
        seiteAField = new JTextField(10);
        frame.add(seiteAField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Seite b:"), gbc);
        gbc.gridx = 1;
        seiteBField = new JTextField(10);
        frame.add(seiteBField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Seite c:"), gbc);
        gbc.gridx = 1;
        seiteCField = new JTextField(10);
        frame.add(seiteCField, gbc);

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

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(new JLabel("Winkel γ (°):"), gbc);
        gbc.gridx = 1;
        winkelGammaField = new JTextField(10);
        frame.add(winkelGammaField, gbc);

        // 🔹 Button-Panel
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Berechnen");
        JButton backButton = new JButton("Zurück");
        backButton.addActionListener(e -> frame.dispose());
        buttonPanel.add(calculateButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonPanel, gbc);

        // 🔹 Fußzeile
        JLabel footer = new JLabel("Gib mindestens 3 Werte ein (z. B. 2 Seiten & 1 Winkel ODER 2 Winkel & 1 Seite).",
                SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        frame.add(footer, gbc);

        // 🔹 Berechnungslogik 
        calculateButton.addActionListener(e -> {
            try {
                Double a = getValue(seiteAField);
                Double b = getValue(seiteBField);
                Double c = getValue(seiteCField);
                Double alpha = getValue(winkelAlphaField);
                Double beta = getValue(winkelBetaField);
                Double gamma = getValue(winkelGammaField);

                // 🔹 Falls zwei Winkel gegeben sind, berechne den dritten
                if (alpha != null && beta != null && gamma == null) {
                    gamma = 180 - alpha - beta;
                }
                if (alpha == null && beta != null && gamma != null) {
                    alpha = 180 - beta - gamma;
                }
                if (beta == null && alpha != null && gamma != null) {
                    beta = 180 - alpha - gamma;
                }

                // 🔹 Falls zwei Seiten + eingeschlossener Winkel gegeben sind, berechne dritte Seite mit Kosinussatz
                if (a != null && b != null && gamma != null && c == null) {
                    c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(Math.toRadians(gamma))); // Kosinussatz
                }
                if (a != null && c != null && beta != null && b == null) {
                    b = Math.sqrt(a * a + c * c - 2 * a * c * Math.cos(Math.toRadians(beta))); // Kosinussatz
                }
                if (b != null && c != null && alpha != null && a == null) {
                    a = Math.sqrt(b * b + c * c - 2 * b * c * Math.cos(Math.toRadians(alpha))); // Kosinussatz
                }

                // 🔹 Falls zwei Winkel + eine Seite gegeben sind, berechne fehlende Seiten mit Sinussatz
                if (a != null && alpha != null && beta != null && b == null) {
                    b = (a / Math.sin(Math.toRadians(alpha))) * Math.sin(Math.toRadians(beta)); // Sinussatz
                }
                if (a != null && alpha != null && gamma != null && c == null) {
                    c = (a / Math.sin(Math.toRadians(alpha))) * Math.sin(Math.toRadians(gamma)); // Sinussatz
                }
                if (b != null && beta != null && alpha != null && a == null) {
                    a = (b / Math.sin(Math.toRadians(beta))) * Math.sin(Math.toRadians(alpha)); // Sinussatz
                }
                if (b != null && beta != null && gamma != null && c == null) {
                    c = (b / Math.sin(Math.toRadians(beta))) * Math.sin(Math.toRadians(gamma)); // Sinussatz
                }
                if (c != null && gamma != null && alpha != null && a == null) {
                    a = (c / Math.sin(Math.toRadians(gamma))) * Math.sin(Math.toRadians(alpha)); // Sinussatz
                }
                if (c != null && gamma != null && beta != null && b == null) {
                    b = (c / Math.sin(Math.toRadians(gamma))) * Math.sin(Math.toRadians(beta)); // Sinussatz
                }

                // 🔹 Falls nur 3 Seiten gegeben sind, berechne einen Winkel mit Kosinussatz
                if (a != null && b != null && c != null && alpha == null) {
                    alpha = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c))); // Kosinussatz
                }
                if (a != null && b != null && c != null && beta == null) {
                    beta = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c))); // Kosinussatz
                }
                if (a != null && b != null && c != null && gamma == null) {
                    gamma = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b))); // Kosinussatz
                }

                // 🔹 Jetzt erst Winkelsumme überprüfen
                if (alpha != null && beta != null && gamma != null) {
                    double sum = alpha + beta + gamma;
                    if (Math.abs(sum - 180) > 0.01) {  // Toleranz wegen Rundungsfehlern
                        JOptionPane.showMessageDialog(frame, "Ungültige Winkelsumme! Bitte überprüfe die Eingaben.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // 🔹 Sicherheitsprüfung, bevor Ergebnisfenster geöffnet wird
                if (a == null || b == null || c == null || alpha == null || beta == null || gamma == null) {
                    JOptionPane.showMessageDialog(frame, "Berechnung unvollständig! Bitte überprüfe die Eingaben.", "Fehler", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                new ErgebnisFenster("Allgemeines Dreieck\n\n"
                        + "Seite a: " + round(a) + "\n"
                        + "Seite b: " + round(b) + "\n"
                        + "Seite c: " + round(c) + "\n"
                        + "Winkel α: " + round(alpha) + "°\n"
                        + "Winkel β: " + round(beta) + "°\n"
                        + "Winkel γ: " + round(gamma) + "°");

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

    // 🔹 Methode zählt die Anzahl der ausgefüllten Felder
    private int countValues(Double... values) {
        int count = 0;
        for (Double value : values) {
            if (value != null) count++;
        }
        return count;
    }

    // 🔹 Werte auf 2 Nachkommastellen runden
    private String round(double value) {
        return String.format("%.2f", value);
    }
}

