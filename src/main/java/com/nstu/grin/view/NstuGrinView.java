package com.nstu.grin.view;

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
        grinPanel.add(toolbarsPanel, BorderLayout.NORTH);



        grinPanel.setBackground(Color.white);
        setContentPane(grinPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }


}
