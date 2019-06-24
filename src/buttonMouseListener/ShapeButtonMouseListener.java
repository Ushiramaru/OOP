package buttonMouseListener;

import pen.Pen;
import shape.Shape;
import shape.userShape.UserShape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShapeButtonMouseListener implements MouseListener {

    private Shape shape;

    public ShapeButtonMouseListener(Shape shape) {
        super();
        if (shape != null) {
            shape.setFPoints(new Point());
            shape.setSPoints(new Point());
        }
        this.shape = shape;
    }

    public void mouseClicked(MouseEvent e) {
        Pen.setSelectedShape(shape);
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
