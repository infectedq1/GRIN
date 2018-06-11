package com.nstu.grin.view;

import com.nstu.grin.entities.Const;
import com.nstu.grin.entities.ToolbarButton;

import javax.swing.*;
import java.awt.*;

public class

GrinWindow extends JPanel {

    public GrinWindow (){
        setPreferredSize(new Dimension(550, 550));
        setBackground(Color.BLACK);
    }

    public void setColor(Color color) {
        this.setBackground(color);
    }


}
