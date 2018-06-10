package com.nstu.grin.view;
import javax.swing.*;
import java.awt.*;


import static com.nstu.grin.entities.Const.*;
import static com.nstu.grin.entities.ToolbarButton.*;

public class WindowToolbar extends JPanel {
    private JToolBar wtb = new JToolBar();

    public WindowToolbar() {
        setLayout(new BorderLayout());

        add(wtb, BorderLayout.NORTH);
        wtb.setFloatable(false);

        JButton bt = new JButton(RED_BUTTON);
        wtb.add(bt);

        bt = new JButton(GREEN_BUTTON);
        wtb.add(bt);

        bt = new JButton(BLUE_BUTTON);
        wtb.add(bt);
    }
}
