package pen;

import java.awt.*;
import java.util.ArrayList;
import shape.Shape;
import shapeArray.*;

public class Pen {
    private static Shape selectedShape;
    private static Graphics graphics;

    public static void setGraphics(Graphics graphics) {
        Pen.graphics = graphics;
    }

    public static void setSelectedShape(Shape selectedShape) {
        Pen.selectedShape = selectedShape;
    }

    public static void setFPoint(Point fPoint) {
        if (selectedShape != null) {
            selectedShape.setFPoints(fPoint);
        }
    }

    public static void setSPoint(Point sPoint) {
        if (selectedShape != null) {
            selectedShape.setSPoints(sPoint);
        }
    }

    public static void drawShape() {
        if (selectedShape != null) {
            ShapeArray.addShape(selectedShape);
            ArrayList<Point> pointArray = selectedShape.getPointArray();
            for (Point drawPoint : pointArray) {
                graphics.drawLine(drawPoint.x, drawPoint.y, drawPoint.x, drawPoint.y);
            }
        } else {
            clearCanvas();
        }
    }

    public static void clearCanvas() {
        graphics.clearRect(0,0, 1000, 1000);
        ShapeArray.removeShape();
    }
}
