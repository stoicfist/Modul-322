package trigonometrie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GleichschenkligesDreieckView {
    private JFrame frame;
    private JTextField seiteAField, basisField;
    private JLabel resultLabel;

    public GleichschenkligesDreieckView() {
        frame = new JFrame("Gleichschenkliges Dreieck");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Gleiche Seitenlänge a:"));
        seiteAField = new JTextField();
        frame.add(seiteAField);

        frame.add(new JLabel("Basislänge b:"));
        basisField = new JTextField();
        frame.add(basisField);

        JButton calculateButton = new JButton("Berechnen");
        frame.add(calculateButton);

        resultLabel = new JLabel(" ");
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(seiteAField.getText());
                    double b = Double.parseDouble(basisField.getText());

                    if (b >= 2 * a) {
                        resultLabel.setText("Ungültige Werte!");
                        return;
                    }

                    double h = Math.sqrt(a * a - (b / 2) * (b / 2)); // Höhe mit Pythagoras
                    double winkel = Math.toDegrees(Math.acos((b / 2) / a)); // Basiswinkel mit Kosinus

                    new ErgebnisFenster("Höhe h: " + h + "\nBasiswinkel: " + winkel + "°");

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte gültige Zahlen eingeben.");
                }
            }
        });

        frame.setVisible(true);
    }
}
