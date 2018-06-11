package com.nstu.grin.view;

import javax.swing.*;
import java.awt.*;

public class ToolbarsPanel extends JPanel {
    private OperationsToolbar operationsToolbar;
    private WindowToolbar windowToolbar;

    public OperationsToolbar getOperationsToolbar(){
        return operationsToolbar;
    }

    public WindowToolbar getWindowToolbar(){
        return windowToolbar;
    }

    public ToolbarsPanel (){
        operationsToolbar = new OperationsToolbar();
        windowToolbar = new WindowToolbar();
        add(operationsToolbar, BorderLayout.NORTH);
        add(windowToolbar, BorderLayout.SOUTH);
    }
}