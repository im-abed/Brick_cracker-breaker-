package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
 /*   public static String playername() {

        return playerrr;
    }*/
public boolean ddd=false;
    public JFrame frame;

    public static void main(String[] args) {
        int score;

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        showMessageDialog(null, "to play use left & right arrows  \n Press Enter to start", "  info", JOptionPane.INFORMATION_MESSAGE);


        Blockcrapa panel = new Blockcrapa();

        JFrame frame = new JFrame("block Cracking Game");
        frame.setSize(620, 920);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setResizable(false);

/*
        Frame f = new Frame(" Example");
        f.setSize(350, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);*/
/*like packing for table*//*

        Button b1 = new Button("REPLAY");
        b1.setBackground(Color.YELLOW);
        b1.setBounds(50, 250, 250, 50);
        b1.setSize(250, 50);
        b1.setFont(new Font(null, Font.BOLD, 50));


        Button b2 = new Button("EXIT");
        b2.setBackground(Color.RED);
        b2.setBounds(50, 450, 250, 50);
        b2.setSize(250, 50);
        b2.setFont(new Font(null, Font.BOLD, 50));
        f.add(b2);f.add(b1);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
                panel.revalidate();
                panel.update();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);


            }
        });
*/


    }
}
