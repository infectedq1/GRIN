package com.nstu.grin.view;

import com.nstu.grin.entities.OperationButton;
import com.nstu.grin.entities.ToolbarButton;
import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.interfaces.GrinViewInterface;

import javax.swing.*;
import java.awt.*;

public class NstuGrinView extends JFrame implements GrinViewInterface {
    private GrinPresenterInterface presenter;
    private GrinWindow grinWindow;
    private ToolbarsPanel toolbarsPanel;

    public void setPresenter(GrinPresenterInterface pres) {
        presenter = pres;
    }

    public NstuGrinView() {
        createUI();
    }

    public void createUI()
    {
        setTitle("GRIN");
        JPanel grinPanel = new JPanel(new BorderLayout());

        grinWindow = new GrinWindow();
        grinPanel.add(grinWindow,BorderLayout.SOUTH);

        toolbarsPanel = new ToolbarsPanel();
        toolbarsPanel.setToolbarButtonsListener(this::windowToolbarButtonListener);
        toolbarsPanel.setOperationsButtonsListener(this::operationsToolbarButtonListener);

        grinPanel.add(toolbarsPanel, BorderLayout.NORTH);
        grinPanel.setBackground(Color.white);

        setContentPane(grinPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
    private void windowToolbarButtonListener (ToolbarButton btn) {
//        switch (btn){
//            case RED:
//                grinWindow.setColor(Color.RED);
//                break;
//            case BLUE:
//                grinWindow.setColor(Color.BLUE);
//                break;
//            case GREEN:
//                grinWindow.setColor(Color.GREEN);
//                break;
//        }
    }
    private void operationsToolbarButtonListener (OperationButton btn) {

    }

}
