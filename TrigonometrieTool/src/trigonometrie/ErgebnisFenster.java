package trigonometrie;

import javax.swing.*;

public class ErgebnisFenster {
    public ErgebnisFenster(String ergebnisText) {
        JFrame frame = new JFrame("Ergebnis");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea(ergebnisText);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
