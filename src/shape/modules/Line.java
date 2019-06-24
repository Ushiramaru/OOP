package shape.modules;

import java.awt.*;
import java.util.ArrayList;
import shape.Shape;

public class Line extends Shape {

    public Shape clone() {
        Shape cloneShape = new Line();
        cloneShape.setFPoints(new Point(fPoint.x,fPoint.y));
        cloneShape.setSPoints(new Point(sPoint.x,sPoint.y));
        return cloneShape;
    }

    public ArrayList<Point> calculatePoints() {
        ArrayList<Point> pointArray = new ArrayList<>();
        int dx = (sPoint.x > fPoint.x) ? (sPoint.x - fPoint.x) : (fPoint.x - sPoint.x);
        int dy = (sPoint.y > fPoint.y) ? (sPoint.y - fPoint.y) : (fPoint.y - sPoint.y);
        int sx = (sPoint.x >= fPoint.x) ? (1) : (-1);
        int sy = (sPoint.y >= fPoint.y) ? (1) : (-1);

        if (dy < dx) {
            int d = (dy << 1) - dx;
            int d1 = dy << 1;
            int d2 = (dy - dx) << 1;
            pointArray.add(new Point(fPoint.x,fPoint.y));
            int x = fPoint.x + sx;
            int y = fPoint.y;
            for (int i = 1; i <= dx; i++) {
                if (d > 0) {
                    d += d2;
                    y += sy;
                } else {
                    d += d1;
                }
                pointArray.add(new Point(x,y));
                x+=sx;
            }
        } else {
            int d = (dx << 1) - dy;
            int d1 = dx << 1;
            int d2 = (dx - dy) << 1;
            pointArray.add(new Point(fPoint.x, fPoint.y));
            int x = fPoint.x;
            int y = fPoint.y + sy;
            for (int i = 1; i <= dy; i++) {
                if (d > 0) {
                    d += d2;
                    x += sx;
                }
                else {
                    d += d1;
                }
                pointArray.add(new Point(x,y));
                y+=sy;
            }
        }
        return pointArray;
    }

}
