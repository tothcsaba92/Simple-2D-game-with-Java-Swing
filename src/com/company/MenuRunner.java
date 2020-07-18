package com.company;


import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class MenuRunner extends JPanel implements ActionListener, KeyListener, LineListener {

    JButton buttonNewGame;
    JButton buttonScore;
    JButton buttonExit;
    JFrame menuJ;
    Game game = new Game();
    Menu menu = new MenuPanel();


    public MenuRunner() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.buttonNewGame = new JButton("NEW GAME");
        this.buttonScore = new JButton("SCORE");
        this.buttonExit = new JButton("EXIT");
        this.setLayout(null);
        buttonNewGame.setBounds(260, 150, 250, 40);
        buttonNewGame.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonNewGame.setForeground(Color.BLACK);
        buttonNewGame.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        this.add(buttonNewGame);
        buttonNewGame.addActionListener(this::newGame);

        buttonScore.setBounds(260, 250, 250, 40);
        buttonScore.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonScore.setForeground(Color.BLACK);
        buttonScore.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        this.add(buttonScore);

        buttonScore.addActionListener(this::score);

        buttonExit.setBounds(260, 350, 250, 40);
        buttonExit.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        this.add(buttonExit);
        buttonExit.addActionListener(this::exit);

        menuJ = new JFrame();
        menuJ.setTitle("MENU");
        menuJ.setSize(810, 485);
        menuJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuJ.setLocationRelativeTo(null);
        menuJ.setResizable(false);
        menuJ.setLocationRelativeTo(null);
        menuJ.setContentPane(this);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        menu.paintComponent(g);

        System.out.println("Menu run");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void exit(ActionEvent event) {
        if (event.getActionCommand().equals("EXIT")) {
            menuJ.dispatchEvent(new WindowEvent(menuJ, WindowEvent.WINDOW_CLOSING));
        }
    }

    public void newGame(ActionEvent event) {
        if (event.getActionCommand().equals("NEW GAME")) {
            game.window();
            menuJ.setVisible(false);
        }
    }

    public void score(ActionEvent event) {
        if (event.getActionCommand().equals("SCORE")) {
            MenuScoreRunner menuScoreRunner = new MenuScoreRunner();
            menuScoreRunner.scoreMenu();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    public void createMenu() {
        menuJ.setVisible(true);
        validate();
        try {
            MenuEndRunner.loadResults();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String audioFilePath = "data/sound/Megalovania.wav";
        //SoundPlayer player = new SoundPlayer();
        // player.play(audioFilePath);


    }


    @Override
    public void update(LineEvent event) {

    }

}