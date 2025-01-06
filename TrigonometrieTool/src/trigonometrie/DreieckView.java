package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DreieckView {
    private JFrame frame;
    private JTextField baseField, heightField;
    private JLabel resultLabel;

    public DreieckView() {
        frame = new JFrame("Berechnungen - Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JLabel("Basis:"));
        baseField = new JTextField();
        frame.add(baseField);

        frame.add(new JLabel("Höhe:"));
        heightField = new JTextField();
        frame.add(heightField);

        JButton calculateButton = new JButton("Berechnen");
        frame.add(calculateButton);

        resultLabel = new JLabel("Ergebnis: ");
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double base = Double.parseDouble(baseField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    Dreieck dreieck = new Dreieck(base, height);
                    resultLabel.setText("Fläche: " + dreieck.calculateArea());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte gültige Zahlen eingeben.");
                }
            }
        });

        frame.setVisible(true);
    }
}
