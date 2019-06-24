package pen;

import java.awt.*;
import java.util.ArrayList;
import shape.Shape;
import shape.userShape.UserShape;
import shape.userShape.UserShapeCreator;
import shapeArray.*;

public class Pen {

    private static Shape selectedShape;
    private static Graphics graphics;
    private static boolean isCreateUserShape = false;
    private static UserShapeCreator userShapeCreator = new UserShapeCreator();
    private static boolean isDrawUserShape = false;

    public static void setGraphics(Graphics graphics) {
        Pen.graphics = graphics;
    }

    public static void setSelectedShape(Shape selectedShape) {
        if (selectedShape != null) {
            isDrawUserShape = selectedShape.getClass().getName().equals(UserShape.class.getName());
            Pen.selectedShape = selectedShape.clone();
        } else {
            Pen.selectedShape = null;
        }
    }

    public static void setFPoint(Point fPoint) {
        if (selectedShape != null) {
            selectedShape.setFPoints(fPoint);
        }
    }

    public static boolean isUserShape() {
        return isCreateUserShape;
    }

    public static void setIsUserShape() {
        isCreateUserShape = !isCreateUserShape;
    }

    public static Shape getUserShape() {
        Shape shape = userShapeCreator.getUserShape();
        userShapeCreator.resetSubShapes();
        return shape;
    }

    public static void setSPoint(Point sPoint) {
        if (selectedShape != null) {
            selectedShape.setSPoints(sPoint);
        }
    }

    public static void drawShape() {
        if (selectedShape != null) {
            Shape shape = selectedShape.clone();
            ShapesArray.addShape(shape);
            ArrayList<Point> pointArray = shape.getPointArray();
            if (isDrawUserShape) {
                for (Shape subShape : ((UserShape)shape).getSubShapes()) {
                    ShapesArray.addShape(subShape);
                    if (isCreateUserShape) {
                        userShapeCreator.addSubShape(subShape);
                    }
                }
            } else {
                ShapesArray.addShape(shape);
                if (Pen.isUserShape()) {
                    userShapeCreator.addSubShape(shape);
                }
            }
            for (Point drawPoint : pointArray) {
                graphics.drawLine(drawPoint.x, drawPoint.y, drawPoint.x, drawPoint.y);
            }
        } else {
            clearCanvas();
        }
    }

    public static void clearCanvas() {
        graphics.clearRect(0,0, 1000, 1000);
        ShapesArray.removeShape();
    }

}
