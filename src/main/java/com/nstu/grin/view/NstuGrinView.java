package com.nstu.grin.view;

import com.nstu.grin.entities.RequiresEDT;
import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.interfaces.GrinViewInterface;
import com.nstu.grin.pojo.GraphLine;
import com.nstu.grin.pojo.Graphic;
import com.nstu.grin.entities.CustomButton;
import com.nstu.grin.utils.Utils;
import com.nstu.grin.view.pojo.ColorizedGraphLine;
import com.nstu.grin.view.pojo.ColorizedGraphic;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class NstuGrinView extends JFrame implements GrinViewInterface {
    private GrinPresenterInterface presenter;
    private GrinWindow grinWindow;
    private Toolbar toolbar;
    private LegendPanel legendPanel;

    public void setPresenter(GrinPresenterInterface pres) {
        presenter = pres;
    }

    @Override
    public void drawGraphic(Graphic graphic) {
        ColorizedGraphic colorizedGraphic = new ColorizedGraphic();
        for (GraphLine graphLine: graphic.getGraphLines()){
            colorizedGraphic.addGraphLine(new ColorizedGraphLine(graphLine, Utils.getRandomColor()));
        }
        drawColorizedGraphic(colorizedGraphic);
    }

    @RequiresEDT
    private void drawColorizedGraphic(ColorizedGraphic graphic){
        legendPanel.inflateLegend(graphic);
        getContentPane().add(legendPanel, BorderLayout.SOUTH);
        grinWindow.drawGraphic(graphic);
    }

    public NstuGrinView() {

    }

    public void createUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
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
