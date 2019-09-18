package com.uncooleben.OOAD.lab01.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;


public class AntGameFrame extends JFrame
{
    private ArrayList<JTextField> antPos=new ArrayList<>();
    private JTextField poleLen=new JTextField(10);
    private JLabel time=new JLabel();
    private JLabel killed=new JLabel();
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
        antPos.add(new JTextField(8));
        antPos.add(new JTextField(8));
        antPos.add(new JTextField(8));
        antPos.add(new JTextField(8));
        antPos.add(new JTextField(8));
        //set layout
        GridBagLayout layout=new GridBagLayout();
        infoPanel.setLayout(layout);
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.weightx=100;
        constraints.weighty=100;
        constraints.gridy=0;
        for(constraints.gridx=0;constraints.gridx<5;constraints.gridx++)
        {
            JPanel tempPanel=new JPanel();
            tempPanel.add(new JLabel("Ant"+constraints.gridx+":",JLabel.RIGHT));
            tempPanel.add(antPos.get(constraints.gridx));
            infoPanel.add(tempPanel,constraints);
        }
        constraints.gridy=1;
        constraints.gridx=0;
        {
            JPanel tempPanel=new JPanel();
            tempPanel.add(new JLabel("PoleLength:",JLabel.RIGHT));
            tempPanel.add(poleLen);
            infoPanel.add(tempPanel,constraints);
        }
        constraints.gridx=1;
        {
            JPanel tempPanel=new JPanel();
            tempPanel.add(new JLabel("Time:",JLabel.RIGHT));
            tempPanel.add(time);
            infoPanel.add(tempPanel,constraints);
        }
        constraints.gridx=2;
        {
            JPanel tempPanel=new JPanel();
            tempPanel.add(new JLabel("Killed:",JLabel.RIGHT));
            tempPanel.add(killed);
            infoPanel.add(tempPanel,constraints);
        }
        //add subpanel to main panel
        add(infoPanel, BorderLayout.NORTH);
        add(new DrawComponent(),BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

    }
}
