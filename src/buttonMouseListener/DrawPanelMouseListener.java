package buttonMouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import pen.Pen;


public class DrawPanelMouseListener implements MouseListener {

    public DrawPanelMouseListener() {
        super();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        Pen.setFPoint(e.getPoint());
    }

    public void mouseReleased(MouseEvent e) {
        Pen.setSPoint(e.getPoint());
        Pen.drawShape();
    }
}
