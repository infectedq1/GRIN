package com.nstu.grin.view.pojo;

import com.nstu.grin.pojo.GraphLine;

import java.awt.*;

public class ColorizedGraphLine {
    private GraphLine graphLine;
    private Color color;

    public ColorizedGraphLine(GraphLine graphLine, Color color) {
        this.graphLine = graphLine;
        this.color = color;
    }

    public GraphLine getGraphLine() {
        return graphLine;
    }

    public void setGraphLine(GraphLine graphLine) {
        this.graphLine = graphLine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
