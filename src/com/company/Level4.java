package com.company;

import java.awt.*;

public class Level4 extends Level {

    public Level4() {
        background = Toolkit.getDefaultToolkit().createImage("data/gif/cityBack4.jpg");
        elevators.add(new ElevatorDown(340, 1));
        elevators.add(new ElevatorUp(340, 1));
        elevators.add(new ElevatorUp(420, 2));
        elevators.add(new ElevatorDown(420,2));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image12, 770, 490, null);
        g.drawImage(image12, 5, 420, null);
        g.drawImage(image12, 770, 350, null);
        g.drawImage(image12, 5, 280, null);
        g.drawImage(image12, 770, 210, null);
        g.drawImage(image12, 5, 140, null);

        g.drawImage(image7, 0, 490, null);
        g.drawImage(image8, 380, 490, null);
        g.drawImage(image2, 460, 490, null);
        g.drawImage(image2, 60, 420, null);
        g.drawImage(image8, 380, 420, null);
        g.drawImage(image7, 460, 420, null);
        g.drawImage(image8, 380, 350, null);
        g.drawImage(image7, 0, 350, null);
        g.drawImage(image2, 460, 350, null);
        g.drawImage(image8, 380, 280, null);
        g.drawImage(image2, 60, 280, null);
        g.drawImage(image7, 460, 280, null);
        g.drawImage(image8, 380, 210, null);
        g.drawImage(image7, 0, 210, null);
        g.drawImage(image2, 460, 210, null);
        g.drawImage(image8, 380, 135, null);
        g.drawImage(image2, 60, 135, null);
        g.drawImage(image7, 460, 135, null);
        g.setFont(new Font("arial", Font.BOLD, 40));
        g.drawString("Level 4", 310, 50);

    }
}