package com.company;

import java.awt.*;

public class BonusFruit extends Entity{

    private Image image;

    int cpuX, cpuY;

    public BonusFruit(String file) {

        image = Toolkit.getDefaultToolkit().createImage(file);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, getCpuX(), getCpuY(), null);
    }

    public int getCpuX() {
        return cpuX;
    }

    public void setCpuX(int cpuX) {
        this.cpuX = cpuX;
    }

    public int getCpuY() {
        return cpuY;
    }

    public void setCpuY(int cpuY) {
        this.cpuY = cpuY;
    }

}
