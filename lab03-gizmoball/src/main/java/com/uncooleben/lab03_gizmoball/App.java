package com.uncooleben.lab03_gizmoball;

import javax.swing.JFrame;

import com.uncooleben.lab03_gizmoball.gui.MainFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
