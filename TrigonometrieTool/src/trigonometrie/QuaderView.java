package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class QuaderView {
    private JFrame frame;
    private JTextField lengthField, widthField, heightField;
    private JLabel resultLabel;

    public QuaderView() {
        frame = new JFrame("Berechnungen - Quader");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        frame.add(new JLabel("Länge:"));
        lengthField = new JTextField();
        frame.add(lengthField);

        frame.add(new JLabel("Breite:"));
        widthField = new JTextField();
        frame.add(widthField);

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
                    double length = Double.parseDouble(lengthField.getText());
                    double width = Double.parseDouble(widthField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    Quader quader = new Quader(length, width, height);
                    resultLabel.setText("Volumen: " + quader.calculateVolume());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte gültige Zahlen eingeben.");
                }
            }
        });

        frame.setVisible(true);
    }
}