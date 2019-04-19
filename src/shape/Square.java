package shape;

import java.awt.*;
import java.util.ArrayList;

public class Square extends Rectangle {

    @Override
    public shape.Shape clone() {
        Shape cloneShape = new Square();
        cloneShape.setFPoints(fPoint);
        cloneShape.setSPoints(sPoint);
        return cloneShape;
    }

    protected void fixPoint() {
        if (Math.abs(fPoint.x - sPoint.x) <= Math.abs(fPoint.y - sPoint.y)) {
            if (fPoint.y <= sPoint.y) {
                sPoint.y = fPoint.y + Math.abs(fPoint.x - sPoint.x);
            } else {
                sPoint.y = fPoint.y - Math.abs(fPoint.x - sPoint.x);
            }
        } else {
            if (fPoint.x <= sPoint.x) {
                sPoint.x = fPoint.x + Math.abs(fPoint.y - sPoint.y);
            } else {
                sPoint.x = fPoint.x - Math.abs(fPoint.y - sPoint.y);
            }
        }
    }

    @Override
    public ArrayList<Point> calculatePoints() {
        fixPoint();
        return super.calculatePoints();
    }
}
