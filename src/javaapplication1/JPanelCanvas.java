package javaapplication1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
/**
 *Class implements board of SUDOKU inherits after JPanel
 */
public class JPanelCanvas extends JPanel implements MouseListener {

    private final Controller controller;
    /**
     * Method to set size of board 
     */
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public JPanelCanvas(Controller controller) {
        this.controller = controller;
    }
    
   
/**
 * method which draw board(crossed lines) and border of one field
 */
    public void paintComponent(Graphics g) {       
        super.paintComponent(g);
        
        g.setColor(Color.black);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                int x = controller.get(r, c);

                if (x > 0) {
                    g.drawString(Integer.toString(x), 500 / 9 * c + 27, 500 / 9 * r + 30);
                }

                int m = (c == 3 || c == 6) ? 3 : 0;
                g.drawLine(0, 500 * c / 9, 500, 500 * c / 9);
                g.drawLine(0, 500 * c / 9 + m, 500, 500 * c / 9 + m);
            }

            int m = (r == 3 || r == 6) ? 3 : 0;
            g.drawLine(500 * r / 9, 0, 500 * r / 9, 500);
            g.drawLine(500 * r / 9 + m, 0, 500 * r / 9 + m, 500);

        }

        int c = controller.getCurrentSelection()[0];
        int r = controller.getCurrentSelection()[1];
        g.setColor(Color.red);
        g.drawRect(c * 500 / 9, r * 500 / 9, 500 / 9, 500 / 9);
    }

    @Override
    /**
     * Method implements click and set by controller current selection
     */
    public void mouseClicked(MouseEvent e) {        
        controller.setCurentSelection(convertCoord(e.getX()),convertCoord(e.getY()));
        // repaint sprawia ze buttony znikaja, bez repainta nie wyswietli obramowania po zmianie zaznaczenia?
        repaint();
    }
    /**
     * Converts to position on the board 
     * @param position current position on the board
     * @return converted position
     */
    private static int convertCoord(int position) {
        return Math.min((int)(position / 55.5), 8);
    }

    @Override
    public void mousePressed(MouseEvent e) {        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
