package com.nstu.grin.view;

import com.nstu.grin.view.pojo.ColorizedGraphLine;
import com.nstu.grin.view.pojo.ColorizedGraphic;

import javax.swing.*;
import java.awt.*;

public class LegendPanel extends JPanel {
    public LegendPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
    }

    public void inflateLegend(ColorizedGraphic graphic){
        removeAll();
        for (ColorizedGraphLine graphLine: graphic.getColorizedGraphLines()){
            add(new LegendEntry(graphLine.getColor(), graphLine.getGraphLine().getName()));
        }
        repaint();
    }
}
