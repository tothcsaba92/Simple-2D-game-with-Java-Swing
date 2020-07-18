package com.company;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class MenuScoreRunner extends JPanel implements ActionListener, KeyListener, LineListener {
    Timer tm = new Timer(5, this);
    JFrame menuscore;
    JButton buttonBack;


    public MenuScoreRunner() {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.buttonBack = new JButton("BACK");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        tm.start();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
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

    @Override
    public void update(LineEvent event) {

    }

    public void back(ActionEvent event) {
        if (event.getActionCommand().equals("BACK")) {
            menuscore.setVisible(false);

        }
    }


    public void scoreMenu() {

        menuscore = new JFrame();
        menuscore.setTitle("SCOREMENU");
        menuscore.setSize(650, 550);
        menuscore.setVisible(true);

        menuscore.setLocationRelativeTo(null);
        menuscore.setResizable(false);
        menuscore.setLocationRelativeTo(null);

        MenuScoreRunner panel3 = new MenuScoreRunner();
        panel3.setLayout(new BorderLayout());

        buttonBack.setSize(250, 40);
        buttonBack.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonBack.setForeground(Color.BLACK);
        buttonBack.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        panel3.add(buttonBack);
        buttonBack.addActionListener(this::back);
        panel3.add(buttonBack, BorderLayout.SOUTH);


        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        String[] headers = {"Player name", "Score"};
        model.setColumnIdentifiers(headers);
        ArrayList<SaveScore> score = MenuEndRunner.getSaveScoreList();
        Collections.sort(score);
        for (int i = 0; i < score.size(); i++) {
            SaveScore saveScore = score.get(i);
            model.addRow(new Object[]{saveScore.getPlayerName(), saveScore.getPlayerScore()});
        }
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(300, 300);
        panel3.add(scroll, BorderLayout.CENTER);
        menuscore.setContentPane(panel3);


    }
}