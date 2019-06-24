package shape.userShape;

import shape.Shape;

import java.awt.*;
import java.util.ArrayList;

public class UserShape extends Shape {

    private ArrayList<Shape> subShapes;
    private int height,width;

    public UserShape(int height,int width, ArrayList<Shape> subShapes) {
        this.height = height;
        this.width = width;
        this.subShapes = subShapes;
    }

    public ArrayList<Shape> getSubShapes() {
        return subShapes;
    }

    private void calculateSubShapesPoints() {
        int newHeight = Math.abs(fPoint.y - sPoint.y);
        int newWidth = Math.abs(fPoint.x - sPoint.x);
        int x = fPoint.x < sPoint.x? 1: -1;
        int y = fPoint.y < sPoint.y? 1: -1;
        for (Shape subShape : subShapes) {
            subShape.getFPoint().x = x*subShape.getFPoint().x*newWidth/width + fPoint.x;
            subShape.getFPoint().y = y*subShape.getFPoint().y*newHeight/height + fPoint.y;
            subShape.getSPoint().x = x*subShape.getSPoint().x*newWidth/width + fPoint.x;
            subShape.getSPoint().y = y*subShape.getSPoint().y*newHeight/height + fPoint.y;
        }
    }

    @Override
    public Shape clone() {
        ArrayList<Shape> subShapes = new ArrayList<>();
        for (Shape subShape : this.subShapes) {
            subShapes.add(subShape.clone());
        }
        Shape cloneShape = new UserShape(height,width,subShapes);
        cloneShape.setFPoints(new Point(fPoint.x,fPoint.y));
        cloneShape.setSPoints(new Point(sPoint.x,sPoint.y));
        return cloneShape;
    }

    @Override
    protected ArrayList<Point> calculatePoints() {
        calculateSubShapesPoints();
        ArrayList<Point> pointsArray = new ArrayList<>();
        for (Shape subShape : subShapes) {
            pointsArray.addAll(subShape.getPointArray());
        }
        return pointsArray;
    }

}
