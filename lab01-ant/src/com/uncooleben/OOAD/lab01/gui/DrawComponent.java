package com.uncooleben.OOAD.lab01.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DrawComponent extends JComponent
{
    private int width;
    private int height;
    private double centerX;
    private double centerY;

    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;
        //draw boundary
        double leftX=1;
        double topY=1;
        Dimension size=this.getSize();
        width=size.width;
        height=size.height;
        System.out.println(size);
        Rectangle2D boundary=new Rectangle2D.Double(leftX,topY,width-3,height-2);
        g2.draw(boundary);
        //draw pole
        centerX=boundary.getCenterX();
        centerY=boundary.getCenterY();
        Line2D pole=new Line2D.Double(centerX-width/2,centerY,centerX+width/2,centerY);
        g2.draw(pole);
    }
}
