package com.nstu.grin.view;

import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.interfaces.GrinViewInterface;

import javax.swing.*;
import java.awt.*;

public class NstuGrinView extends JFrame implements GrinViewInterface {
    private GrinPresenterInterface presenter;

    public void setPresenter(GrinPresenterInterface pres) {
        presenter = pres;
    }

    public NstuGrinView() {
        createUI();
    }

    public void createUI()
    {
        JFrame grinFrame = new JFrame("GRIN");
        JPanel grinPanel = new JPanel(new BorderLayout());
        grinFrame.setContentPane(grinPanel);
        grinPanel.setBackground(Color.white);
        grinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grinFrame.setBounds(100,500,500,300);
        grinFrame.setVisible(true);
        grinFrame.setLocationRelativeTo(null);
    }


}
