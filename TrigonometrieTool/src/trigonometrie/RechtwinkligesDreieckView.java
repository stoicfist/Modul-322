package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechtwinkligesDreieckView {
    private JFrame frame;
    private JTextField seiteAField, seiteBField;
    private JLabel resultLabel;

    public RechtwinkligesDreieckView() {
        frame = new JFrame("Rechtwinkliges Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Kathete a:"));
        seiteAField = new JTextField();
        frame.add(seiteAField);

        frame.add(new JLabel("Kathete b:"));
        seiteBField = new JTextField();
        frame.add(seiteBField);

        JButton calculateButton = new JButton("Berechnen");
        frame.add(calculateButton);

        resultLabel = new JLabel(" ");
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(seiteAField.getText());
                    double b = Double.parseDouble(seiteBField.getText());

                    double c = Math.sqrt(a * a + b * b); // Hypotenuse mit Satz des Pythagoras
                    double alpha = Math.toDegrees(Math.atan(a / b)); // Winkel alpha berechnen
                    double beta = 90 - alpha; // Winkel beta (weil rechtwinklig)

                    new ErgebnisFenster("Hypotenuse: " + c + "\nWinkel α: " + alpha + "°\nWinkel β: " + beta + "°");

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte gültige Zahlen eingeben.");
                }
            }
        });

        frame.setVisible(true);
    }
}

