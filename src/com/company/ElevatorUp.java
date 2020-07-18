package com.company;

import java.awt.*;

public class ElevatorUp extends Elevator {

    ElevatorUp(int x, double speed) {
        super(x, speed);
        y = 571;
        direction = -1;


    }

    public void update() {
        if (Math.abs(y - upPoint) <= 5) {
            y = 571;
        }
       super.update();


    }

    @Override
    public void loadImage() {
        elevator = Toolkit.getDefaultToolkit().createImage("data/picture/fel40x40.jpeg");

    }
}
