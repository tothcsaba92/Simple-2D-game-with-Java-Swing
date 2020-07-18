package com.company;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Entity {

    int x = 0, y = 515, velX = 0;
    Image walkLeft;
    Image walkRight;
    Image idleByRight;
    Image idleByLeft;
    Image deadLeft;
    Image deadRight;
    Image jumpLeft;
    Image jumpRight;
    private int interval = 100;
    private Timer timer;
    int delay = 1000;
    int period = 1000;
    public int score = interval; // ezt kell kimentened DR. SIKURA
    boolean winner = false;
    int live = 1;
    boolean dying = false;
    private Timer dyingAnimationTimer = new Timer();
    int endPointX = 769;
    int endPointY = 95;
    int startPointX = 0;
    int startPointY = 515;


    Player() {

        walkLeft = Toolkit.getDefaultToolkit().createImage("data/gif/walkLeft.gif");
        walkRight = Toolkit.getDefaultToolkit().createImage("data/gif/walkRight.gif");
        idleByRight = Toolkit.getDefaultToolkit().createImage("data/gif/idleByRight.gif");
        idleByLeft = Toolkit.getDefaultToolkit().createImage("data/gif/idleByLeft.gif");
        deadLeft = Toolkit.getDefaultToolkit().createImage("data/gif/deadLeft.gif");
        deadRight = Toolkit.getDefaultToolkit().createImage("data/gif/deadRight.gif");
        jumpLeft = Toolkit.getDefaultToolkit().createImage("data/gif/jumpLeft.gif");
        jumpRight = Toolkit.getDefaultToolkit().createImage("data/gif/jumpRight.gif");

    }


    public void startTimer() {
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);
    }


    private final int setInterval() {
        if (x == endPointX && y == endPointY) {
            winner = true;
            timer.cancel();
            score = interval;
            System.out.println(score + "eredmeny");
            return 0;
        } else {
            return --interval;
        }
    }

    public void die() {
        live--;

        dying = true;
        dyingAnimationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                dying = false;
                x = startPointX;
                y = startPointY;
            }
        }, 2000);
        if (isDead()) {
            score = interval;
            timer.cancel();
        }

    }

    private void drawDie(Graphics g) {

        if (velX <= 0) {
            g.drawImage(deadLeft, x, y, null);
        } else {
            g.drawImage(deadRight, x, y, null);
        }

    }

    public boolean isDead() {
        return live <= 0;
    }

    public boolean isDying() {
        return dying;
    }

    public void paintComponent(Graphics g) {
        if (dying) {
            drawDie(g);
        } else {
            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.BOLD, 20));
            g.drawString("Score = " + interval, 50, 50);
            g.drawString("Lives = " + live, 700, 50);

            if (velX == 0 && x == endPointX) {
                g.drawImage(idleByLeft, x, y, null);

            } else if (velX == 0 && x == startPointX+1) {
                g.drawImage(idleByRight, x, y, null);
            } else if (velX > 0) {
                g.drawImage(walkRight, x, y, null);
            } else {
                g.drawImage(walkLeft, x, y, null);
            }
        }
    }

    public void addBonus(int bonus) {
        interval += bonus;
    }


    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void update() {
        if (!dying) {
            if (x < startPointX || x > 770) {
                velX = -velX;
            }
            if (x == startPointX) {
                velX = 0;
                x = startPointX+1;

            }
            if (x == 770) {
                velX = 0;
                x = endPointX;
            }
            if (x == endPointX && y == startPointY) {
                y = 445;
            }
            if (x == startPointX+1 && y == 445) {
                y = 375;
            }
            if (x == endPointX && y == 375) {
                y = 305;
            }
            if (x == startPointX+1 && y == 305) {
                y = 235;
            }
            if (x == endPointX && y == 235) {
                y = 165;
            }
            if (x == startPointX+1 && y == 165) {
                y = endPointY;
            }
            x = x + velX;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public Rectangle bounds() {
        return (new Rectangle(x, y, 50, 50));
    }

    public int getScore() {
        return score;
    }

    public boolean isWinner() {
        return winner;
    }
}
