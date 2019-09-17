package com.uncooleben.OOAD.lab01.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class AntGameFrame extends JFrame
{
    public AntGameFrame()
    {
        JPanel buttonPanel=new JPanel();
        JPanel drawPanel=new JPanel();
        JPanel infoPanel=new JPanel();
        setTitle("Ant Game");
        //set frame size according to actual screen size
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        final int DEFAULT_WIDTH=(int)(screenSize.width*0.7);
        final int DEFAULT_HEIGHT=(int) (screenSize.height*0.7);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        //format button panel
        buttonPanel.add(new JButton("Start"));
        buttonPanel.add(new JButton("Reset"));
        buttonPanel.add(new JButton("Exit"));
        //format info panel
        //set layout
        GridBagLayout layout=new GridBagLayout();
        infoPanel.setLayout(layout);
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.weightx=100;
        constraints.weighty=100;

        constraints.gridx=0;
        constraints.gridy=0;

        constraints.ipadx=20;
        constraints.ipady=10;
        infoPanel.add(new JLabel("A1"),constraints);
        constraints.gridx=0;
        constraints.gridy=1;
        infoPanel.add(new JLabel("A2"),constraints);


        add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);



    }
}
