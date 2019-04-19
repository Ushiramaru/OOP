package buttonMouseListener;

import pen.Pen;
import shape.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShapeButtonMouseListener implements MouseListener {

    private Shape selectedShape;

    public ShapeButtonMouseListener(Shape selectedShape) {
        super();
        this.selectedShape = selectedShape;
    }

    public void mouseClicked(MouseEvent e) {
        Pen.setSelectedShape(selectedShape);
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }
}
