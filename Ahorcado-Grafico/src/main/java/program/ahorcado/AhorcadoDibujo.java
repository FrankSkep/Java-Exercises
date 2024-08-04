package program.ahorcado;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class AhorcadoDibujo extends JPanel {
    private int errores;

    public void setErrores(int errores) {
        this.errores = errores;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujo del ahorcado
        g.drawLine(30, 199, 140, 199); // Base
        g.drawLine(80, 200, 80, 50); // Poste vertical
        g.drawLine(80, 50, 140, 50); // Poste horizontal
        g.drawLine(140, 50, 140, 70); // Cuerda

        switch (errores) {
            case 6:
                g.drawLine(140, 150, 150, 180); // Pierna derecha
            case 5:
                g.drawLine(140, 150, 130, 180); // Pierna izquierda
            case 4:
                g.drawLine(140, 120, 160, 110); // Brazo derecho
            case 3:
                g.drawLine(140, 120, 120, 110); // Brazo izquierdo
            case 2:
                g.drawLine(140, 100, 140, 150); // Cuerpo
            case 1:
                g.drawOval(125, 70, 30, 30); // Cabeza
                break;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
