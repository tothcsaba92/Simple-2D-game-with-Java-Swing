package com.company;


import java.awt.*;


public class MenuPanel extends Menu {


    private Image menubackground;


    public MenuPanel() {
        menubackground = Toolkit.getDefaultToolkit().createImage("data/gif/city.gif");
    }


    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(menubackground, 0, 0, null);
    }
}
