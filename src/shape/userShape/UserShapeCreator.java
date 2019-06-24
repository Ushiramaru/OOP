package shape.userShape;

import shape.Shape;

import java.awt.*;
import java.util.ArrayList;

public class UserShapeCreator {

    private Point startPoint = new Point();
    private ArrayList<Shape> subShapes = new ArrayList<>();

    public void addSubShape(Shape subShape) {
        subShapes.add(subShape.clone());
    }

    public Shape getUserShape() {
        if (subShapes.size() != 0) {
            int height = getHeight();
            int width = getWight();
            for (Shape subShape : subShapes) {
                subShape.setFPoints(new Point(subShape.getFPoint().x-startPoint.x, subShape.getFPoint().y-startPoint.y));
                subShape.setSPoints(new Point(subShape.getSPoint().x-startPoint.x, subShape.getSPoint().y-startPoint.y));
            }
            return new UserShape(height, width, subShapes);
        } else {
            return null;
        }
    }

    private int getHeight() {
        int maxY = 0;
        int minY = Integer.MAX_VALUE;
        for (Shape shape : subShapes) {
            if (Integer.max(shape.getFPoint().y,shape.getSPoint().y) > maxY) {
                maxY = Integer.max(shape.getFPoint().y,shape.getSPoint().y);
            }
            if (Integer.min(shape.getFPoint().y,shape.getSPoint().y) < minY) {
                minY = Integer.min(shape.getFPoint().y,shape.getSPoint().y);
            }
        }
        startPoint.y = minY;
        return maxY - minY;
    }

    private int getWight() {
        int maxX = 0;
        int minX = Integer.MAX_VALUE;
        for (Shape shape : subShapes) {
            if (Integer.max(shape.getFPoint().x,shape.getSPoint().x) > maxX) {
                maxX = Integer.max(shape.getFPoint().x,shape.getSPoint().x);
            }
            if (Integer.min(shape.getFPoint().x,shape.getSPoint().x) < minX) {
                minX = Integer.min(shape.getFPoint().x,shape.getSPoint().x);
            }
        }
        startPoint.x = minX;
        return maxX - minX;
    }

    public void resetSubShapes() {
        subShapes = new ArrayList<>();
    }

}
