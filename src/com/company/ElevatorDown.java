package com.company;

import java.awt.*;

public class ElevatorDown extends Elevator {



    ElevatorDown(int x, int speed) {
        super(x, speed);
        y = upPoint;
        direction = 1;
    }

    public void update() {
        if (Math.abs(y - downPoint) <= 5) {
            y = upPoint;
        }
        super.update();

    }

    @Override
    public void loadImage() {
        elevator = Toolkit.getDefaultToolkit().createImage("data/picture/le40x40.png");
    }
}
