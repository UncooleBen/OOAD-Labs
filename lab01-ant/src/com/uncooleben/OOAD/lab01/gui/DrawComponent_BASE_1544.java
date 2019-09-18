package com.uncooleben.OOAD.lab01.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;
        double leftX=0;
        double topY=0;
        double width=100;
        double height=100;
        Rectangle2D rect=new Rectangle2D.Double(leftX,topY,width,height);
        g2.draw(rect);
    }
}
