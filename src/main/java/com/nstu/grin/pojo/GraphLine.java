package com.nstu.grin.pojo;

import java.util.ArrayList;
import java.util.List;

public class GraphLine {
    private List<Point> points;
    private String name = "";

    public GraphLine(List<Point> points) {
        this.points = points;
    }

    public GraphLine() {
        this(new ArrayList<>());
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
