package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechtwinkligesDreieckView {
    private JFrame frame;
    private JTextField seiteAField, seiteBField, seiteCField, winkelAField, winkelBField;

    public RechtwinkligesDreieckView() {
        frame = new JFrame("Rechtwinkliges Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // HEADER
        JLabel header = new JLabel("Rechtwinkliges Dreieck Berechnung", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(header, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Eingabefelder
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Kathete a:"), gbc);
        gbc.gridx = 1;
        seiteAField = new JTextField(10);
        frame.add(seiteAField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Kathete b:"), gbc);
        gbc.gridx = 1;
        seiteBField = new JTextField(10);
        frame.add(seiteBField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Hypotenuse c:"), gbc);
        gbc.gridx = 1;
        seiteCField = new JTextField(10);
        frame.add(seiteCField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(new JLabel("Winkel α (°):"), gbc);
        gbc.gridx = 1;
        winkelAField = new JTextField(10);
        frame.add(winkelAField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(new JLabel("Winkel β (°):"), gbc);
        gbc.gridx = 1;
        winkelBField = new JTextField(10);
        frame.add(winkelBField, gbc);

        // Button-Panel
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

        // Fußzeile
        JLabel footer = new JLabel("Gib mindestens 2 Werte ein (z. B. 2 Seiten oder 1 Seite & 1 Winkel).", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        frame.add(footer, gbc);

        // Berechnungslogik
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double a = getValue(seiteAField);
                    Double b = getValue(seiteBField);
                    Double c = getValue(seiteCField);
                    Double alpha = getValue(winkelAField);
                    Double beta = getValue(winkelBField);

                    // Mindestens zwei Eingaben prüfen
                    int anzahlEingaben = countValues(a, b, c, alpha, beta);
                    if (anzahlEingaben < 2) {
                        JOptionPane.showMessageDialog(frame, "Bitte gib mindestens 2 Werte ein!\n"
                                + "Erlaubt: 2 Seiten oder 1 Seite & 1 Winkel.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Fehlende Winkel berechnen
                    if (alpha != null && beta == null) beta = 90 - alpha;
                    if (beta != null && alpha == null) alpha = 90 - beta;

                    // ✅ Pythagoras: Falls zwei Katheten gegeben sind
                    if (a != null && b != null && c == null) {
                        c = Math.sqrt(a * a + b * b);
                    }

                    // ✅ Falls Hypotenuse und eine Kathete gegeben sind
                    if (a != null && c != null && b == null) {
                        b = Math.sqrt(c * c - a * a);
                    }
                    if (b != null && c != null && a == null) {
                        a = Math.sqrt(c * c - b * b);
                    }

                    // ✅ Falls eine Seite und ein Winkel gegeben sind
                    if (a != null && alpha != null && c == null) c = a / Math.sin(Math.toRadians(alpha));
                    if (b != null && alpha != null && c == null) c = b / Math.cos(Math.toRadians(alpha));

                    if (c != null && alpha != null && a == null) a = c * Math.sin(Math.toRadians(alpha));
                    if (c != null && alpha != null && b == null) b = c * Math.cos(Math.toRadians(alpha));

                    // ✅ Winkel berechnen, falls noch nicht geschehen
                    if (a != null && b != null && alpha == null) {
                        alpha = Math.toDegrees(Math.atan(a / b));  // α = arctan(a/b)
                        beta = 90 - alpha;  // β = 90 - α
                    }

                    // Sicherheitscheck: Falls Berechnung fehlschlägt
                    if (c == null || alpha == null || beta == null) {
                        JOptionPane.showMessageDialog(frame, "Berechnung unvollständig! Bitte überprüfe die Eingaben.", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    new ErgebnisFenster("Rechtwinkliges Dreieck\n\n"
                            + "Seite a: " + round(a) + "\n"
                            + "Seite b: " + round(b) + "\n"
                            + "Seite c: " + round(c) + "\n"
                            + "Winkel α: " + round(alpha) + "°\n"
                            + "Winkel β: " + round(beta) + "°\n"
                            + "Winkel γ: 90°");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Bitte gültige Zahlen eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    // Hilfsmethode, um Werte aus Textfeldern zu holen
    private Double getValue(JTextField field) {
        String text = field.getText();
        return text.isEmpty() ? null : Double.parseDouble(text);
    }

    private int countValues(Double... values) {
        int count = 0;
        for (Double value : values) {
            if (value != null) count++;
        }
        return count;
    }

    private String round(double value) {
        return String.format("%.2f", value);
    }
}
