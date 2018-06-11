package com.nstu.grin.view;

import com.nstu.grin.entities.OperationButton;
import com.nstu.grin.entities.ToolbarButton;
import com.nstu.grin.interfaces.OnButtonClickListener;

import javax.swing.*;
import java.awt.*;

public class ToolbarsPanel extends JPanel {
    private OperationsToolbar operationsToolbar;
    private WindowToolbar windowToolbar;

    public void setOperationsButtonsListener(OnButtonClickListener<OperationButton> operationsButtonsListener){
        operationsToolbar.setOnButtonClickListener(operationsButtonsListener);
    }

    public void setToolbarButtonsListener(OnButtonClickListener<ToolbarButton> toolbarButtonsListener){
        windowToolbar.setOnButtonClickListener(toolbarButtonsListener);
    }

    public ToolbarsPanel (){
        operationsToolbar = new OperationsToolbar();
        windowToolbar = new WindowToolbar();
        add(operationsToolbar, BorderLayout.NORTH);
        add(windowToolbar, BorderLayout.SOUTH);
    }
}
