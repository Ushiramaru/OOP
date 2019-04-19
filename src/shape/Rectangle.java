package shape;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends Shape {

    public Shape clone() {
        Shape cloneShape = new Rectangle();
        cloneShape.setFPoints(fPoint);
        cloneShape.setSPoints(sPoint);
        return cloneShape;
    }

    public ArrayList<Point> calculatePoints() {
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
