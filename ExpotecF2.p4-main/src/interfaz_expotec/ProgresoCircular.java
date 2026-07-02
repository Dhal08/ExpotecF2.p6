package interfaz_expotec;

import java.awt.*;
import javax.swing.*;

public class ProgresoCircular extends JPanel {

    private int value = 80;

    public ProgresoCircular() {
        setOpaque(false);
    }

    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Math.min(getWidth(), getHeight()) - 10;

        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        int grosor = 18;

        // Fondo del círculo
        g2.setStroke(new BasicStroke(grosor,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        g2.setColor(new Color(225, 225, 225));
        g2.drawArc(x, y, size, size, 90, -360);

        // Progreso
        g2.setColor(new Color(90, 90, 90));

        int angulo = (int) (360 * value / 100.0);

        g2.drawArc(x, y, size, size, 90, -angulo);

        // Borde exterior
        g2.setStroke(new BasicStroke(5));
        g2.setColor(new Color(45, 45, 45));
        g2.drawOval(x, y, size, size);

        // Círculo interior
        int margen = 30;

        g2.setColor(Color.WHITE);

        g2.fillOval(
                x + margen,
                y + margen,
                size - margen * 2,
                size - margen * 2);

        g2.setStroke(new BasicStroke(3));

        g2.setColor(new Color(60, 60, 60));

        g2.drawOval(
                x + margen,
                y + margen,
                size - margen * 2,
                size - margen * 2);

        // Porcentaje
        String texto = value + "%";

        Font f = new Font("Arial", Font.BOLD, size / 5);

        g2.setFont(f);

        FontMetrics fm = g2.getFontMetrics();

        int tx = getWidth() / 2 - fm.stringWidth(texto) / 2;

        int ty = getHeight() / 2;

        g2.setColor(new Color(100, 110, 130));

        g2.drawString(texto, tx, ty);

        // NOTA
        Font f2 = new Font("Arial", Font.PLAIN, size / 10);

        g2.setFont(f2);

        FontMetrics fm2 = g2.getFontMetrics();

        String nota = "NOTA";

        int tx2 = getWidth() / 2 - fm2.stringWidth(nota) / 2;

        g2.drawString(nota, tx2, ty + 30);

        g2.dispose();

    }
}
