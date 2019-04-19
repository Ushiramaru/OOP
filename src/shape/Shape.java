package shape;

import com.google.gson.annotations.SerializedName;

import java.awt.*;
import java.util.ArrayList;

public abstract class Shape {

    Shape() {
        typeName = getClass().getName();
    }

    @SerializedName("type")
    private String typeName;

    protected Point fPoint, sPoint;

    public void setFPoints(Point fPoint) {
        this.fPoint = fPoint;
    }

    public void setSPoints(Point sPoint) {
        this.sPoint = sPoint;
    }

    public ArrayList<Point> getPointArray() {
        return this.calculatePoints();
    }

    public abstract Shape clone();

    protected abstract ArrayList<Point> calculatePoints();
}