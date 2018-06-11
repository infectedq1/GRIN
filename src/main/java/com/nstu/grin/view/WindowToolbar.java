package com.nstu.grin.view;
import com.nstu.grin.interfaces.OnButtonClickListener;

import javax.swing.*;
import java.awt.*;

import static com.nstu.grin.entities.Const.*;
import static com.nstu.grin.entities.ToolbarButton.*;

public class WindowToolbar extends JPanel {

    private JToolBar wtb = new JToolBar();

    private OnButtonClickListener listener;

    public void setOnButtonClickListener(OnButtonClickListener listener){
        this.listener = listener;
    }

    public WindowToolbar() {
        setLayout(new BorderLayout());

        add(wtb, BorderLayout.NORTH);
        wtb.setFloatable(false);

        JButton bt = new JButton(RED_BUTTON);
        bt.addActionListener((e) -> listener.onButtonClick(RED));
        wtb.add(bt);

        bt = new JButton(GREEN_BUTTON);
        bt.addActionListener((e) -> listener.onButtonClick(GREEN));
        wtb.add(bt);

        bt = new JButton(BLUE_BUTTON);
        bt.addActionListener((e) -> listener.onButtonClick(BLUE));
        wtb.add(bt);
    }
}
