package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllgemeinesDreieckView {
    private JFrame frame;
    private JTextField seiteAField, seiteBField, winkelCField;
    private JLabel resultLabel;

    public AllgemeinesDreieckView() {
        frame = new JFrame("Allgemeines Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Seite a:"));
        seiteAField = new JTextField();
        frame.add(seiteAField);

        frame.add(new JLabel("Seite b:"));
        seiteBField = new JTextField();
        frame.add(seiteBField);

        frame.add(new JLabel("Winkel C (°):"));
        winkelCField = new JTextField();
        frame.add(winkelCField);

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
                    double winkelC = Double.parseDouble(winkelCField.getText());

                    if (winkelC <= 0 || winkelC >= 180) {
                        resultLabel.setText("Winkel ungültig!");
                        return;
                    }

                    double c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(Math.toRadians(winkelC))); // Kosinussatz
                    double winkelA = Math.toDegrees(Math.asin((a * Math.sin(Math.toRadians(winkelC))) / c)); // Sinussatz
                    double winkelB = 180 - winkelA - winkelC;

                    new ErgebnisFenster("Seite c: " + c + "\nWinkel A: " + winkelA + "°\nWinkel B: " + winkelB + "°");

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte gültige Zahlen eingeben.");
                }
            }
        });

        frame.setVisible(true);
    }
}
