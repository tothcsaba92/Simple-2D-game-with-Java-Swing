package com.company;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuEndRunner extends JPanel implements ActionListener, KeyListener, LineListener {
    private JFrame menue;
    private Menu endmenu = new MenuEnd();
    private JTextField textField;
    private JButton buttonNewGame;
    private JButton buttonSubmit;
    private JButton buttonExit;
    private Game game;
    private int endScore;
    private String name;
    private JLabel label3 = new JLabel();
    private static ArrayList<SaveScore> saveScoreList = new ArrayList<>();

    public static ArrayList<SaveScore> getSaveScoreList() {
        return (ArrayList<SaveScore>) saveScoreList.clone();
    }

    //todo
    public void saveResults() throws IOException {
        // PrintWriter pw = new PrintWriter(new FileOutputStream("score.txt"));
//        for (SaveScore saveScore : saveScoreList) {
//            pw.println(saveScore.toString());
//            pw.close();
            BufferedWriter output;
            output = new BufferedWriter(new FileWriter("score.txt", true));
            String sizeX = name+","+endScore;
            output.append(sizeX);
            output.newLine();
            output.close();
       // }

    }

    public static void loadResults() throws FileNotFoundException {
        saveScoreList.clear();
        Scanner sc = new Scanner(new File("score.txt"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineParts = line.split(",");
            SaveScore saveScore = new SaveScore(
                    lineParts[0],
                    Integer.parseInt(lineParts[1])
            );
            saveScoreList.add(saveScore);

        }
    }

//    static {
//        saveScoreList.add(new SaveScore("Name", 234));
//        saveScoreList.add(new SaveScore("Name34", 34));
//        saveScoreList.add(new SaveScore("NameDne", 1234));
//    }

    public MenuEndRunner(Game game) {

        this.game = game;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.textField = new JTextField(25);
        this.buttonNewGame = new JButton("NEW GAME");
        this.buttonSubmit = new JButton("SUBMIT");
        this.buttonExit = new JButton("EXIT");
        this.setLayout(null);
        JLabel label1 = new JLabel("GAME OVER:");
        label1.setBounds(200, 30, 500, 100);
        label1.setFont(new Font("Courier", Font.BOLD, 36));
        label1.setForeground(Color.RED);
        this.add(label1);

        JLabel label2 = new JLabel("SCORE:");
        label2.setBounds(200, 130, 500, 100);
        label2.setFont(new Font("Courier", Font.BOLD, 36));
        label2.setForeground(Color.RED);
        this.add(label2);


        label3.setBounds(370, 130, 500, 100);
        label3.setFont(new Font("Courier", Font.BOLD, 36));
        label3.setForeground(Color.RED);
        this.add(label3);


        textField.setBounds(230, 250, 200, 30);
        this.add(textField);

        buttonSubmit.setBounds(210, 300, 250, 40);
        buttonSubmit.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonSubmit.setForeground(Color.BLACK);
        buttonSubmit.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        this.add(buttonSubmit);
        buttonSubmit.addActionListener(this::submit);


        buttonNewGame.setBounds(30, 450, 250, 40);
        buttonNewGame.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonNewGame.setForeground(Color.BLACK);
        buttonNewGame.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        this.add(buttonNewGame);
        buttonNewGame.addActionListener(this::newGame);


        buttonExit.setBounds(350, 450, 250, 40);
        buttonExit.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.6f));
        this.add(buttonExit);
        buttonExit.addActionListener(this::exit);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        endmenu.paintComponent(g);
        // todo loadResults

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

    public void exit(ActionEvent event) {
        if (event.getActionCommand().equals("EXIT")) {
            menue.dispatchEvent(new WindowEvent(menue, WindowEvent.WINDOW_CLOSING));
        }
    }

    public void newGame(ActionEvent event) {
        if (event.getActionCommand().equals("NEW GAME")) {
            menue.setVisible(false);
            if (game != null) {
                game.endGame();
            }
            game = new Game();
            game.window();


        }
    }

    public void submit(ActionEvent event) {
        if (event.getActionCommand().equals("SUBMIT")) {
            name = textField.getText();
            //System.out.println(name);
            saveScoreList.add(new SaveScore(name, endScore));
            //todo
            try {
                saveResults();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MenuScoreRunner menuScoreRunner = new MenuScoreRunner();
            menuScoreRunner.scoreMenu();


        }
    }

    public void endMenu() {
        menue = new JFrame();
        menue.setTitle("ENDMENU");
        menue.setSize(650, 550);
        menue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menue.setLocationRelativeTo(null);
        menue.setResizable(false);
        menue.setLocationRelativeTo(null);
        endScore = game.getPlayer().score;

        label3.setText(String.valueOf(endScore));
        menue.add(this);
        menue.setVisible(true);
    }


}
