package shapeArray;

import shape.Shape;

import java.util.ArrayList;

public class ShapesArray {

    private static ArrayList<Shape> shapeArray = new ArrayList<>();

    public static void addShape(Shape shape) {
        shapeArray.add(shape.clone());
    }

    public static void removeShape() {
        shapeArray.clear();
    }

    public static ArrayList<Shape> getShapeArray() {
        return shapeArray;
    }
}
