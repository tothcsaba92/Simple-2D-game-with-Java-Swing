package com.company;


import java.awt.*;


public abstract class Elevator extends Entity {
    int x, y, direction;
    double speed;
    int downPoint = 571;
    int upPoint = 80;

    protected Image elevator;

     Elevator(int x, double speed) {
         this.x = x;
         this.speed = speed;
         loadImage();
        //elevator = Toolkit.getDefaultToolkit().createImage("data/picture/le40x40.png");
    }
    public void paintComponent(Graphics g) {
        g.drawImage(elevator,x,y,null);
    }

    public void update() {
        y = (int) Math.round(y + direction*speed);
    }
    public abstract void loadImage();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle bounds(){
        return (new Rectangle(x,y,50,50));
    }
}
