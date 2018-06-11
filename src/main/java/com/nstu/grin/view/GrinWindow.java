package com.nstu.grin.view;

import com.nstu.grin.pojo.GraphLine;
import com.nstu.grin.pojo.Graphic;
import com.nstu.grin.pojo.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

import static com.nstu.grin.utils.Utils.*;
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

    private Graphic currentGraphic;

    private Color axisColor = new Color(0xFFFFFFFF);
    private Color backgroundColor = new Color(0xFF444444);

    private BufferedImage buffer;

    public GrinWindow () {
        this(900, 900);
    }

    public GrinWindow(int width, int height) {
        this.width = width;
        this.height = height;

        maxY = 10;
        maxX = 10;

        setPreferredSize(new Dimension(width, height));
        drawAll();
        initListeners();
    }

    private void initListeners(){
        addMouseWheelListener(e -> {
            maxY += e.getWheelRotation();
            maxX += e.getWheelRotation();
            drawAll();
        });
    }

    private void drawAll(){
        centerX = width / 2;
        centerY = height / 2;

        cellX = width / (maxX * 2);
        cellY = height / (maxY * 2);

        initBuffer();
        safeAction(currentGraphic, this::drawGraphic);
        repaint();
    }

    public void drawGraphic(Graphic graphic) {
        currentGraphic = safeCall(graphic, g -> {
            Graphics graphics2D = buffer.createGraphics();
            List<Point> points;
            Point point0, point1;
            int i;
            for (GraphLine graphLine: g.getGraphLines()){
                graphics2D.setColor(getRandomColor());
                points = graphLine.getPoints();
                for (i = 0; i < points.size() - 1; ++i){
                    point0 = points.get(i);
                    point1 = points.get(i + 1);
                    graphics2D.drawLine(
                        toPixelX(point0.getX()), toPixelY(point0.getY()),
                        toPixelX(point1.getX()), toPixelY(point1.getY())
                    );
                }
            }
            return g;
        });
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

        for (int i = 0, y = cellY; i < maxY; ++i, y += cellY){
            g.drawLine(centerX - cellSegmLength, centerY - y, centerX + cellSegmLength, centerY - y);
            g.drawLine(centerX - cellSegmLength, centerY + y, centerX + cellSegmLength, centerY + y);
        }

        for (int i = 0, x = cellX; i < maxX * 2; ++i, x += cellX){
            g.drawLine(centerX - x, centerY - cellSegmLength, centerX - x, centerY + cellSegmLength);
            g.drawLine(centerX + x, centerY - cellSegmLength, centerX + x, centerY + cellSegmLength);
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

    private Random random = new Random();
    private Color getRandomColor() {
        return new Color(
                random.nextInt((256 - 128)) + 128,
                random.nextInt((256 - 128) ) + 128,
                random.nextInt((256 - 128)) + 128
        );
    }
}
