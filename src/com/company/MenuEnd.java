package com.company;

import java.awt.*;

public class MenuEnd extends Menu {

    private Image endBackground;

    public MenuEnd() {
        endBackground = Toolkit.getDefaultToolkit().createImage("data/picture/End2.jpeg");
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(endBackground, 0, 0, null);
    }
}
