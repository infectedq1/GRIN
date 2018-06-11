package com.nstu.grin.view;

import com.nstu.grin.entities.OperationButton;
import com.nstu.grin.entities.RequiresEDT;
import com.nstu.grin.entities.ToolbarButton;
import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.interfaces.GrinViewInterface;
import com.nstu.grin.pojo.GraphLine;
import com.nstu.grin.pojo.Graphic;
import com.nstu.grin.utils.Utils;
import com.nstu.grin.view.pojo.ColorizedGraphLine;
import com.nstu.grin.view.pojo.ColorizedGraphic;

import javax.swing.*;
import java.awt.*;

public class NstuGrinView extends JFrame implements GrinViewInterface {
    private GrinPresenterInterface presenter;
    private GrinWindow grinWindow;
    private ToolbarsPanel toolbarsPanel;

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
        grinWindow.drawGraphic(graphic);
    }

    public NstuGrinView() {

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
        presenter.onRefresh();
    }
    private void windowToolbarButtonListener (ToolbarButton btn) {

    }
    private void operationsToolbarButtonListener (OperationButton btn) {

    }
}
