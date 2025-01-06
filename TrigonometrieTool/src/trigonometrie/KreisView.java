package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class KreisView {
    private JFrame frame;
    private JTextField radiusField;
    private JLabel resultLabel;

    public KreisView() {
        frame = new JFrame("Berechnungen - Kreis");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JLabel("Radius:"));
        radiusField = new JTextField();
        frame.add(radiusField);

        JButton calculateButton = new JButton("Berechnen");
        frame.add(calculateButton);

        resultLabel = new JLabel("Ergebnis: ");
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radius = Double.parseDouble(radiusField.getText());

                    Kreis kreis = new Kreis(radius);
                    resultLabel.setText("Fläche: " + kreis.calculateArea());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte gültige Zahlen eingeben.");
                }
            }
        });

        frame.setVisible(true);
    }
}
