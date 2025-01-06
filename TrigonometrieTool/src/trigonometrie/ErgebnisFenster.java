package trigonometrie;

import javax.swing.*;
import java.awt.*;

public class ErgebnisFenster {
    public ErgebnisFenster(String ergebnisText) {
        JFrame frame = new JFrame("Ergebnis");
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 🔹 HEADER
        JLabel header = new JLabel("Berechnungsergebnis", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(header, BorderLayout.NORTH);

        // 🔹 Textfeld mit Scrollbar
        JTextArea textArea = new JTextArea(ergebnisText);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 🔹 Schließen-Button
        JButton closeButton = new JButton("Schließen");
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
