package com.nstu.grin.view;

import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.interfaces.GrinViewInterface;
import com.nstu.grin.pojo.Graphic;
import com.nstu.grin.entities.CustomButton;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class NstuGrinView extends JFrame implements GrinViewInterface {
    private GrinPresenterInterface presenter;
    private GrinWindow grinWindow;
    private Toolbar toolbar;
    public void setPresenter(GrinPresenterInterface pres) {
        presenter = pres;
    }

    @Override @RequiresEDT
    public void drawGraphic(Graphic graphic) {
        grinWindow.drawGraphic(graphic);
    }

    public NstuGrinView() {

    }

    public void createUI()
    {
        setTitle("GRIN");
        JPanel grinPanel = new JPanel(new BorderLayout());

        grinWindow = new GrinWindow();
        grinPanel.add(grinWindow, BorderLayout.SOUTH);

        toolbar = new Toolbar();
        toolbar.setOnButtonClickListener(this::toolbarButtonListener);


        grinPanel.add(toolbar, BorderLayout.NORTH);

        grinPanel.setBackground(Color.white);

        setContentPane(grinPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    private void toolbarButtonListener(CustomButton btn) {
        switch (btn) {
            case OPEN_FILE:
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    presenter.openFile(fileChooser.getSelectedFile().getAbsolutePath());
                }

        }
    }

}
