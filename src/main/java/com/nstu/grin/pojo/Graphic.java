package com.nstu.grin.pojo;

import java.util.ArrayList;
import java.util.List;

public class Graphic {
    private List<GraphLine> graphLines;
    private String title;

    public Graphic(List<GraphLine> graphLines) {
        this(graphLines, "");
    }

    public Graphic() {
        this(new ArrayList<>());
    }

    public Graphic(List<GraphLine> graphLines, String title) {
        this.graphLines = graphLines;
        this.title = title;
    }

    public void addGraphLine(GraphLine graphLine){
        graphLines.add(graphLine);
    }

    public List<GraphLine> getGraphLines() {
        return graphLines;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
