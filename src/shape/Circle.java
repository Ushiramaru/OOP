package shape;

import java.awt.*;
import java.util.ArrayList;

public class Circle extends Square {

    @Override
    public Shape clone() {
        Shape cloneShape = new Circle();
        cloneShape.setFPoints(fPoint);
        cloneShape.setSPoints(sPoint);
        return cloneShape;
    }

    @Override
    public ArrayList<Point> calculatePoints() {
        fixPoint();
        ArrayList<Point> pointArray = new ArrayList<>();
        Point center = new Point();
        center.x = Integer.min(fPoint.x,sPoint.x) + Math.round(Math.abs(fPoint.x - sPoint.x)/2);
        center.y = Integer.min(fPoint.y,sPoint.y) + Math.round(Math.abs(fPoint.y - sPoint.y)/2);
        int x = 0;
        int y = Integer.max(fPoint.x,sPoint.x) - center.x;
        int delta = 1 - 2*y;
        int error = 0;
        while(y >= 0) {
            pointArray.add(new Point(center.x + x,center.y + y));
            pointArray.add(new Point(center.x + x,center.y - y));
            pointArray.add(new Point(center.x - x,center.y + y));
            pointArray.add(new Point(center.x - x,center.y - y));
            error = 2 * (delta + y) - 1;
            if ((delta < 0) && (error <= 0)) {
                delta += 2 * (++x) + 1;
                continue;
            }
            if ((delta > 0) && (error > 0)) {
                delta -= 2 * (--y) + 1;
                continue;
            }
            delta += 2 * (++x - y--);
        }
        return pointArray;
    }
}
