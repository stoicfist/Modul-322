package trigonometrie;

import javax.swing.*;
import java.awt.*;

public class MainView {
	private JFrame frame;

	public MainView() {
		frame = new JFrame("Trigonometrie Tool");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 450); // Etwas größere Höhe für Fußzeile
		frame.setLayout(new BorderLayout());

		// 🔹 BUTTON PANEL (mit den 3 Buttons)
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

		JButton rechtwinkligButton = createButton("Rechtwinkliges Dreieck", Color.RED, new Color(255, 200, 200));
		JButton gleichschenkligButton = createButton("Gleichschenkliges Dreieck", Color.BLUE, new Color(200, 200, 255));
		JButton allgemeinesButton = createButton("Allgemeines Dreieck", Color.GREEN, new Color(200, 255, 200));

		rechtwinkligButton.addActionListener(e -> new RechtwinkligesDreieckView());
		gleichschenkligButton.addActionListener(e -> new GleichschenkligesDreieckView());
		allgemeinesButton.addActionListener(e -> new AllgemeinesDreieckView());

		buttonPanel.add(rechtwinkligButton);
		buttonPanel.add(gleichschenkligButton);
		buttonPanel.add(allgemeinesButton);

		// 🔹 FUSSZEILE HINZUFÜGEN
		JLabel footerLabel = new JLabel("Berechnung von Dreiecken mit Trigonometrie", SwingConstants.CENTER);
		footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
		footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		// 🔹 ALLES ZUSAMMENSETZEN
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.add(footerLabel, BorderLayout.SOUTH); // Fußzeile am unteren Rand

		frame.setVisible(true);
	}

	private JButton createButton(String label, Color borderColor, Color fillColor) {
		JButton button = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int width = getWidth();
				int height = getHeight();
				int centerX = width / 2;
				int centerY = height / 2 - 20;

				g2d.setColor(fillColor);
				g2d.fillRoundRect(5, 5, width - 10, height - 10, 20, 20);
				g2d.setColor(borderColor);
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRoundRect(5, 5, width - 10, height - 10, 20, 20);

				if (label.contains("Rechtwinklig")) {
					drawRightTriangle(g2d, centerX, centerY);
				} else if (label.contains("Gleichschenklig")) {
					drawIsoscelesTriangle(g2d, centerX, centerY);
				} else if (label.contains("Allgemeines")) {
					drawScaleneTriangle(g2d, centerX, centerY);
				}
			}
		};

		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setLayout(new BorderLayout());

		JLabel textLabel = new JLabel(label, SwingConstants.CENTER);
		textLabel.setFont(new Font("Arial", Font.BOLD, 14));
		button.add(textLabel, BorderLayout.SOUTH);

		return button;
	}

	private void drawRightTriangle(Graphics2D g2d, int centerX, int centerY) {
		int[] xPoints = { centerX - 20, centerX + 20, centerX - 20 };
		int[] yPoints = { centerY + 20, centerY + 20, centerY };
		g2d.drawPolygon(xPoints, yPoints, 3);
	}

	private void drawIsoscelesTriangle(Graphics2D g2d, int centerX, int centerY) {
		int[] xPoints = { centerX - 20, centerX + 20, centerX };
		int[] yPoints = { centerY + 20, centerY + 20, centerY - 20 };
		g2d.drawPolygon(xPoints, yPoints, 3);
	}

	private void drawScaleneTriangle(Graphics2D g2d, int centerX, int centerY) {
		int[] xPoints = { centerX - 20, centerX + 10, centerX + 20 };
		int[] yPoints = { centerY + 20, centerY, centerY + 20 };
		g2d.drawPolygon(xPoints, yPoints, 3);
	}
}
