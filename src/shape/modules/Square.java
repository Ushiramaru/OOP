package shape.modules;

import java.awt.*;
import java.util.ArrayList;
import shape.Shape;

public class Square extends Shape {

    @Override
    public Shape clone() {
        Shape cloneShape = new Square();
        cloneShape.setFPoints(new Point(fPoint.x,fPoint.y));
        cloneShape.setSPoints(new Point(sPoint.x,sPoint.y));
        return cloneShape;
    }

    private void fixPoint() {
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
        ArrayList<Point> pointArray = new ArrayList<>();
        Point helpPoint;
        for (int i = Integer.min(fPoint.x,sPoint.x); i <= Integer.max(fPoint.x,sPoint.x); i++) {
            helpPoint = new Point(i,fPoint.y);
            pointArray.add(helpPoint);
            helpPoint = new Point(i,sPoint.y);
            pointArray.add(helpPoint);
        }
        for (int i = Integer.min(fPoint.y,sPoint.y); i <= Integer.max(fPoint.y,sPoint.y); i++) {
            helpPoint = new Point(fPoint.x,i);

            pointArray.add(helpPoint);
            helpPoint = new Point(sPoint.x,i);
            pointArray.add(helpPoint);
        }
        return pointArray;
    }
}
