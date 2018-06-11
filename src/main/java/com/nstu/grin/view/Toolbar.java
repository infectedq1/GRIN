package com.nstu.grin.view;

import com.nstu.grin.entities.CustomButton;
import com.nstu.grin.interfaces.OnButtonClickListener;

import javax.swing.*;
import java.awt.*;
import static com.nstu.grin.utils.Utils.safeAction;

public class Toolbar extends JPanel {
    private OnButtonClickListener<CustomButton> listener;

    private JToolBar tb = new JToolBar();

    public void setOnButtonClickListener(OnButtonClickListener<CustomButton> listener){
        this.listener = listener;
    }

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(tb);
        tb.setFloatable(false);

        JButton openFileButton = new JButton("Open file");
        openFileButton.addActionListener((e) -> safeAction(listener, l -> l.onButtonClick(CustomButton.OPEN_FILE)));
        tb.add(openFileButton);
    }
}
