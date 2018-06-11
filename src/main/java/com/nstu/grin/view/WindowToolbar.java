package com.nstu.grin.view;
import com.nstu.grin.entities.ToolbarButton;
import com.nstu.grin.interfaces.OnButtonClickListener;
import com.nstu.grin.utils.Utils;

import javax.swing.*;
import java.awt.*;

import static com.nstu.grin.entities.Const.*;
import static com.nstu.grin.entities.ToolbarButton.*;
import static com.nstu.grin.utils.Utils.safeAction;

public class WindowToolbar extends JPanel {

    private JToolBar wtb = new JToolBar();

    private OnButtonClickListener<ToolbarButton> listener;

    public void setOnButtonClickListener(OnButtonClickListener<ToolbarButton> listener){
        this.listener = listener;
    }

    public WindowToolbar() {
        setLayout(new BorderLayout());

        add(wtb, BorderLayout.NORTH);
        wtb.setFloatable(false);

        JButton bt = new JButton(RED_BUTTON);
        bt.addActionListener((e) -> safeAction(listener, l -> l.onButtonClick(RED)));
        wtb.add(bt);

        bt = new JButton(GREEN_BUTTON);
        bt.addActionListener((e) -> safeAction(listener, l -> l.onButtonClick(GREEN)));
        wtb.add(bt);

        bt = new JButton(BLUE_BUTTON);
        bt.addActionListener((e) -> safeAction(listener, l -> l.onButtonClick(RED)));
        wtb.add(bt);
    }
}
