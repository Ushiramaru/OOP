package shape;

import java.awt.*;
import java.util.ArrayList;

//pool literal
//singleton pattern

public class Line extends Shape {

    public Shape clone() {
        Shape cloneShape = new Line();
        cloneShape.setFPoints(fPoint);
        cloneShape.setSPoints(sPoint);
        return cloneShape;
    }

    public ArrayList<Point> calculatePoints() {
        ArrayList<Point> pointArray = new ArrayList<>();
        Point helpPoint;
        if (fPoint.x == sPoint.x) {
            for (int i = Integer.min(fPoint.y,sPoint.y); i <= Integer.max(fPoint.y,sPoint.y); i+=1) {
                helpPoint = new Point(fPoint.x, i);
                pointArray.add(helpPoint);
            }
        } else {
            pointArray.add(fPoint);
            for (float i = (float) (Integer.min(fPoint.x,sPoint.x)+0.001*Math.abs(fPoint.x - sPoint.x)); i < Integer.max(fPoint.x,sPoint.x); i+=0.001*Math.abs(fPoint.x - sPoint.x)) {
                helpPoint = new Point();
                helpPoint.x = Math.round(i);
                helpPoint.y = Math.round((float) (fPoint.y - sPoint.y) / (float) (fPoint.x - sPoint.x) * (i - fPoint.x) + fPoint.y);
                //System.out.println(helpPoint.x+":"+helpPoint.y);
                pointArray.add(helpPoint);
            }
            pointArray.add(sPoint);
        }
        return pointArray;
    }

}
