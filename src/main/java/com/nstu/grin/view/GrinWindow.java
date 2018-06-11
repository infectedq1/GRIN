package com.nstu.grin.view;

import com.nstu.grin.pojo.GraphLine;
import com.nstu.grin.pojo.Graphic;
import com.nstu.grin.utils.Utils;
import com.sun.xml.internal.ws.message.DOMHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class GrinWindow extends JPanel {
    private int width;
    private int height;
    private int centerX;
    private int centerY;

    private int maxX;
    private int maxY;
    private int cellSegmLength = 4;

    private int cellX;
    private int cellY;

    private Color axisColor = new Color(0xFFFFFFFF);
    private Color backgroundColor = new Color(0xFF444444);

    private BufferedImage buffer;

    public GrinWindow () {
        this(600, 600);
    }

    public GrinWindow(int width, int height) {
        this.width = width;
        this.height = height;

        centerX = width / 2;
        centerY = height / 2;
        maxY = 10;
        maxX = 10;

        cellX = width / (maxX * 2);
        cellY = height / (maxY * 2);

        setPreferredSize(new Dimension(width, height));
        initBuffer();
        repaint();
    }

    public void drawGraphic(Graphic graphic) {
        Utils.safeAction(graphic, g -> {
            int currentColor = getRandomColor();
            g.getGraphLines().stream().map(GraphLine::getPoints).forEach(
                    points -> points.forEach(
                            point -> buffer.setRGB(toPixelX(point.getX()), toPixelY(point.getY()), currentColor)
                    )
            );
        }, () -> {});
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(buffer, 0, 0, null);
    }

    private void initBuffer(){
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = buffer.createGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, width - 1, height - 1);

        g.setColor(axisColor);

        g.drawLine(0, centerY,
                width - 1, centerY);

        g.drawLine(centerX, 0,
                centerX,height - 1);

        for (int i = 0, y = cellY; i < maxY * 2; ++i, y += cellY){
            g.drawLine(centerX - cellSegmLength, y, centerX + cellSegmLength, y);
        }

        for (int i = 0, x = cellX; i < maxX * 2; ++i, x += cellX){
            g.drawLine(x, centerY - cellSegmLength, x, centerY + cellSegmLength);
        }
    }



    private int toPixelX(double val){
        int pixel = (int)((double)cellX / 1000 * ((abs(val)) * 1000));
        return val >= 0 ? pixel + centerX : centerX - pixel;
    }

    private int toPixelY(double val){
        int pixel = (int)((double)cellY / 1000 * ((abs(val)) * 1000));
        return val <= 0 ? pixel + centerY : centerY - pixel;
    }

    private int getRandomColor(){
        return new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)
        ).getRGB();
    }
}
