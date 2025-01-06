package trigonometrie;

import javax.swing.*;
import java.awt.*;

class MainView {
    private JFrame frame;

    public MainView() {
        frame = new JFrame("Trigonometrisches Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(1, 3)); // Eine Reihe mit drei Spalten

        // Erstelle Buttons mit Rahmen (statt Füllung)
        JButton quaderButton = createButton("Quader", Color.RED);
        JButton kreisButton = createButton("Kreis", Color.BLUE);
        JButton dreieckButton = createButton("Dreieck", Color.GREEN);

        quaderButton.addActionListener(e -> new QuaderView());
        kreisButton.addActionListener(e -> new KreisView());
        dreieckButton.addActionListener(e -> new DreieckView());

        frame.add(quaderButton);
        frame.add(kreisButton);
        frame.add(dreieckButton);

        frame.setVisible(true);
    }

    private JButton createButton(String label, Color shapeColor) {
        JButton button = new JButton(label) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(shapeColor);
                g2d.setStroke(new BasicStroke(3)); // Dickere Linien für den Rahmen

                int width = getWidth();
                int height = getHeight();
                int centerX = width / 2;
                int centerY = height / 2 + 20; // Platz nach unten für das Symbol

                if (label.equals("Quader")) {
                    drawOutlinedQuader(g2d, centerX, centerY);
                } else if (label.equals("Kreis")) {
                    g2d.drawOval(centerX - 20, centerY, 40, 40); // Kreis als Rahmen
                } else if (label.equals("Dreieck")) {
                    int[] xPoints = {centerX - 20, centerX + 20, centerX}; // x-Koordinaten
                    int[] yPoints = {centerY + 40, centerY + 40, centerY}; // y-Koordinaten
                    g2d.drawPolygon(xPoints, yPoints, 3); // Dreieck als Rahmen
                }
            }
        };

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.TOP); // Text über dem Symbol

        return button;
    }

    private void drawOutlinedQuader(Graphics2D g2d, int centerX, int centerY) {
        int w = 40, h = 30, depth = 20;

        // Vorderseite (rechteck)
        g2d.drawRect(centerX - w / 2, centerY, w, h);

        // Oberseite
        int[] xTop = {centerX - w / 2, centerX + w / 2, centerX + w / 2 + depth, centerX - w / 2 + depth};
        int[] yTop = {centerY, centerY, centerY - depth, centerY - depth};
        g2d.drawPolygon(xTop, yTop, 4);

        // Seite
        int[] xSide = {centerX + w / 2, centerX + w / 2 + depth, centerX + w / 2 + depth, centerX + w / 2};
        int[] ySide = {centerY, centerY - depth, centerY + h - depth, centerY + h};
        g2d.drawPolygon(xSide, ySide, 4);
    }
}
