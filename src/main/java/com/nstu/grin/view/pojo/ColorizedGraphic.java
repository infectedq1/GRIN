package com.nstu.grin.view.pojo;

import com.nstu.grin.pojo.GraphLine;

import java.util.ArrayList;
import java.util.List;

public class ColorizedGraphic {
    private List<ColorizedGraphLine> colorizedGraphLines;
    private String title;

    public ColorizedGraphic() {
        colorizedGraphLines = new ArrayList<>();
        title = "";
    }

    public List<ColorizedGraphLine> getColorizedGraphLines() {
        return colorizedGraphLines;
    }

    public void setColorizedGraphLines(List<ColorizedGraphLine> colorizedGraphLines) {
        this.colorizedGraphLines = colorizedGraphLines;
    }

    public void addGraphLine(ColorizedGraphLine graphLine){
        colorizedGraphLines.add(graphLine);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
