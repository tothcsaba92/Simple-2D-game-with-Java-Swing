package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends JPanel implements ActionListener, KeyListener {


    Timer tm;
    ArrayList<Level> levels;
    int level = 0;
    static final int bonus = 30;

    public Player getPlayer() {
        return player;
    }

    Player player;


    ArrayList<BonusFruit> bonusFruit;
    private JFrame jf;

    public Game() {
        levels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Level currentLevel = levels.get(level);
        currentLevel.paintComponent(g);
        player.paintComponent(g);

        for (Elevator elevator : currentLevel.getElevators()
        ) {
            elevator.paintComponent(g);
        }

        for (BonusFruit fruit : bonusFruit) {
            fruit.paintComponent(g);
        }

        Iterator<BonusFruit> bonusFruitIterator = bonusFruit.iterator();
        while (bonusFruitIterator.hasNext()) {
            BonusFruit fruit = bonusFruitIterator.next();
//            if(fruit.getCpuY() == 515){
//                System.out.println(player.getX()+" "+player.getY()+" "+fruit.getCpuX()+" "+fruit.getCpuY());
//            }
            if (Math.abs(player.getX() - fruit.getCpuX()) <= 5 && Math.abs(player.getY() - fruit.getCpuY()) <= 5) {
                //System.out.println("I have eaten fruit");
                player.addBonus(bonus);
                bonusFruitIterator.remove();
            } else {
                // System.out.println("do not");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.isWinner()) {
            if (level == levels.size() - 1) {
                System.out.println("Game over");

            } else {
                player.winner = false;
                level++;
                player.setX(player.startPointX);
                player.setY(player.startPointY);
                window();

            }

        }
        if (!player.isDead()) {
            checkCollision();
        }
        repaint();

        Level currentLevel = levels.get(level);
        for (Elevator elevator : currentLevel.getElevators()
        ) {
            elevator.update();

        }
        player.update();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            player.setVelX(-1);
        }
        if (c == KeyEvent.VK_RIGHT) {
            player.setVelX(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void window() {
        bonusFruit = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            BonusFruit fruit = new BonusFruit("data/gif/bf" + i + ".gif");
            bonusFruit.add(fruit);
            if (i % 2 != 0) {
                fruit.setCpuX(60);
                fruit.setCpuY(550 - i * 35);
            } else {
                fruit.setCpuX(690);
                fruit.setCpuY(585 - i * 35);
            }
        }
        if (player == null) {
            player = new Player();
        }

        if (jf != null) {
            jf.setVisible(false);
        }
        jf = new JFrame();
        jf.setTitle("GAME");
        jf.setSize(810, 595);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.add(this);
        jf.setVisible(true);
        if (tm != null) {
            tm.stop();
        }
        tm = new Timer(5, this);
        tm.start();
        player.startTimer();
    }

    public void checkCollision() {
        if (!player.isDying()) {
            Rectangle rect1 = player.bounds();
            Level currentLevel = levels.get(level);
            for (Elevator elevator : currentLevel.getElevators()
            ) {
                Rectangle rect2 = elevator.bounds();
                if (rect1.intersects(rect2)) {
                    player.die();

                    if (player.isDead()) {
                        tm.stop();
                        MenuEndRunner menuEndRunner = new MenuEndRunner(this);
                        menuEndRunner.endMenu();
                        player.setDelay(0);
                    }
                }
            }
        }
    }

    public void endGame() {
        if (jf != null) {
            jf.setVisible(false);
        }
        if (tm != null) {
            tm.stop();
        }
    }
}
