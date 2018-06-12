package com.nstu.grin.view;

import javax.swing.*;
import java.awt.*;

public class LegendEntry extends JPanel {
    public LegendEntry(Color color, String title) {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setPreferredSize(new Dimension(50, 25));
        add(label);

        JPanel colorPanel = new JPanel();
        colorPanel.setSize(new Dimension(50, 50));
        colorPanel.setBackground(color);
        add(colorPanel);
    }
}
