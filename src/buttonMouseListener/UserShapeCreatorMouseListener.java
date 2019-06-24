package buttonMouseListener;

import paint.Paint;
import pen.Pen;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserShapeCreatorMouseListener implements MouseListener {

    private boolean isStart = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        Pen.setIsUserShape();
        if (!Pen.isUserShape()) {
            ((JButton)e.getComponent()).setText("CreateShape");
            Shape shape = Pen.getUserShape();
            if (shape != null) {
//                Component c = e.getComponent();
//                while (!c.getClass().getName().equals(Paint.class.getName())) {
//                    System.out.println(c.getClass().getName());
//                    c = c.getParent();
//                }
                ((Paint)e.getComponent().getParent().getParent().getParent().getParent().getParent()).addUserShapeButton(shape);

            }
        } else {
            ((JButton)e.getComponent()).setText("End/Delete");
        }
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
