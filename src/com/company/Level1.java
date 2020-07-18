package com.company;

import java.awt.*;

public class Level1 extends Level {

    public Level1() {
        background = Toolkit.getDefaultToolkit().createImage("data/gif/cityBack2.png");
        elevators.add(new ElevatorDown(380, 1));
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(image12, 770, 490, null);
        g.drawImage(image12, 5, 420, null);
        g.drawImage(image12, 770, 350, null);
        g.drawImage(image12, 5, 280, null);
        g.drawImage(image12, 770, 210, null);
        g.drawImage(image12, 5, 140, null);

        g.drawImage(image1, 0, 490, null);
        g.drawImage(image6, 420, 490, null);
        g.drawImage(image6, 60, 420, null);
        g.drawImage(image1, 420, 420, null);
        g.drawImage(image1, 0, 350, null);
        g.drawImage(image6, 420, 350, null);
        g.drawImage(image6, 60, 280, null);
        g.drawImage(image1, 420, 280, null);
        g.drawImage(image1, 0, 210, null);
        g.drawImage(image6, 420, 210, null);
        g.drawImage(image6, 60, 135, null);
        g.drawImage(image1, 420, 135, null);
        g.setFont(new Font("arial", Font.BOLD, 40));
        g.drawString("Level 1", 310, 50);

    }
}



