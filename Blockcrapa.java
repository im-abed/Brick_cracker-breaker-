package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Blockcrapa extends JPanel implements KeyListener {
    ArrayList<Block> blocks = new ArrayList<Block>();
    ArrayList<Block> ball = new ArrayList<Block>();
    ArrayList<Block> nagrodz = new ArrayList<Block>();
    ArrayList<Block> nagrodz2 = new ArrayList<Block>();

    public int score = 0;
    public int striken = 0;
    public int level = 1;
    public int ext = 0;
    public int wid = 300 + ext;
    boolean finindic = false;
    public boolean ddd = false;

    Graphics g;
    int finish = 0;
    String preset = "Player";
    String op1 = "";
    int k = 25;
    String name;
    Block paddle = new Block(175, 600, wid, 25, "pad.png");
    Thread thread;
    Animate animate;


    Blockcrapa() {
        super();
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 0 * k, 60, 25, "orange.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 1 * k, 60, 25, "skyblue.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 2 * k, 60, 25, "red.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 3 * k, 60, 25, "purple.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 4 * k, 60, 25, "black.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 5 * k, 60, 25, "green.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 6 * k, 60, 25, "yellow.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 7 * k, 60, 25, "orange.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 8 * k, 60, 25, "skyblue.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 9 * k, 60, 25, "red.png"));
        }
        for (int i = 0; i < 10; i++) {
            blocks.add(new Block((i * 60 + 2), 10 * k, 60, 25, "purple.png"));
        }
        Random ran = new Random();
        if (this.score == 1100) {
            for (int i = 0; i < 10; i++) {
                blocks.add(new Block((i * 60 + 2), (int) (ran.nextInt(50) * (k + 20) * 40 + 2), 60, 25, "yellow.png"));
                //blocks.add(new Block((i * 60 + 2), (13) * k, 60, 25, "yellow.png"));
            }
        }

        blocks.get(ran.nextInt(50)).nagboo = true;
        blocks.get(ran.nextInt(50)).nagboo = true;
        blocks.get(ran.nextInt(50)).nagboo = true;
        blocks.get(ran.nextInt(50)).nagboo = true;
        blocks.get(ran.nextInt(50)).nagboo = true;
        blocks.get(ran.nextInt(50)).nagboo = true;

        blocks.get(ran.nextInt(50)).nagboo2 = true;
        blocks.get(ran.nextInt(50)).nagboo2 = true;
        blocks.get(ran.nextInt(50)).nagboo2 = true;
        blocks.get(ran.nextInt(50)).nagboo2 = true;
        blocks.get(ran.nextInt(50)).nagboo2 = true;
        blocks.get(ran.nextInt(50)).nagboo2 = true;
        ball.add(new Block(273, 437, 50, 50, "ball3.png"));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);//erase andrepaint
        g.setColor(Color.RED);
        int sizeee = 27;
        if (this.level == 2)
            sizeee = 33;
        else if (this.level == 3)
            sizeee = 36;
        g.setFont(new Font(null, Font.BOLD, sizeee));
        //g.drawString("Player " + name, 10, 300);
        g.drawString("your score is " + this.score, 10, 330);
        g.drawString("Striken " + striken, 10, 360);
        g.drawString("Level " + this.level, 10, 390);
        for (Block b : ball)
            b.draw(g, this);
        for (Block b : blocks)
            b.draw(g, this);

        for (Block bw : blocks)
            bw.draw(g, this);

        for (Block nagblock : nagrodz)
            nagblock.draw(g, this);
        paddle.draw(g, this);

        for (Block nagblock2 : nagrodz2)
            nagblock2.draw(g, this);
        paddle.draw(g, this);

    }


    public void update() {
        for (Block nagblock : nagrodz) {
            nagblock.y += 5;
            if (nagblock.intersects(paddle) && !nagblock.washit) {
                nagblock.washit = true;
                Block b2 = new Block((int) paddle.dx + 70, 700, 25, 25, "ball.png");
                ball.add(b2);
            }

        }
        for (Block nagblock2 : nagrodz2) {
            nagblock2.y += 5;
            if (nagblock2.intersects(paddle) && !nagblock2.washit) {
                this.ext = 150;
                nagblock2.washit = true;
                repaint();
                revalidate();
                repaint(paddle);
            }
        }


        for (Block ba : ball) {
            ba.x += ba.dx;
            if (ba.x > (getWidth() - 50) && (ba.dx > 0) || (ba.x < 0)) {
                ba.dx *= -1;
                ba.y += ba.dy;
            }
            if ((ba.y < 0) || (ba.intersects(paddle)))
                ba.dy *= -1;
            ba.y += ba.dy;

            for (Block b : blocks) {
                if ((b.left.intersects(ba) || b.right.intersects(ba)) && !b.washit) {
                    ba.dx *= -1;
                    b.washit = true;
                    striken++;
                    this.score += 10;
                    if (b.nagboo) {
                        nagrodz.add(new Block(b.x, b.y, 40, 55, "diamr.png"));
                    }
                    if (b.nagboo2) {
                        nagrodz2.add(new Block(b.x, b.y, 40, 55, "diamb.png"));
                    }

                } else if (ba.intersects(b) && !b.washit) {
                    ba.dy *= -1;
                    b.washit = true;
                    striken++;
                    this.score += 10;
                    if (b.nagboo) {
                        nagrodz.add(new Block(b.x, b.y, 40, 55, "diamr.png"));
                    }
                    if (b.nagboo2) {
                        nagrodz2.add(new Block(b.x, b.y, 40, 55, "diamb.png"));
                    }

                }

                revalidate();
                repaint();

            }


            if (this.striken == 30) {
                this.level = 2;
                ba.dy = 7.5;
                ba.dx = 7.5;
            }
            if (this.striken >= 50) {
                this.level = 3;
                //ba.dy = 8.5;
                //ba.dx = 7.5;
            }
            if (this.striken == 100) {
                Random ran = new Random();
                for (int i = 0; i < 10; i++) {
                    blocks.add(new Block((i * 60 + 2), (int) (Math.random() * (i + 10) * 40), 60, 25, "orange.png"));
                    //   blocks.add(new Block((ran.nextInt()*(i+20) * 65), (ran.nextInt()*(j+15)*25), 60, 25, "yellow.png"));
                    this.level = 4;

                }
            }
      /*    switch(striken) {
              case ( 30) :
                this.level = 2;
                ba.dy = -7.5;
                ba.dx = 7.5;
              case ( 50) :
                  this.level = 3;
                  ba.dy = -8.5;
                  ba.dx = 8.5;
            }*/
            if (ba.y >= (getHeight()) && ba.y >= (getHeight())) {
        /*        JFrame frame2 = new JFrame("InputDialog Example #1");
                String op1s = JOptionPane.showInputDialog(frame2, "Enter your name ", preset);
                    frame2.dispose();
                    frame2.setVisible(false);*/
//                data[i][j]  = {{names.get(i).toString(), scores.get(i).toString()}  };

                finindic = true;
                ddd = true;
                finish++;
                //   break;

            }


            revalidate();
            repaint();

        }
        if ((finindic == true) && (finish == 1)) {
            Frame f = new Frame("Buttons");
            JLabel labelM = new JLabel("Player's name ");
            labelM.setBounds(50, 30, 200, 30);
            labelM.setFont(new Font(null, Font.BOLD, 27));
            final TextField tf = new TextField();
            tf.setBounds(50, 90, 150, 20);
            Button b = new Button("show the results");
            b.setBounds(50, 120, 300, 50);
            int i = 0;
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Integer> scores = new ArrayList<>();
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.dispose();

                    names.add(tf.getText());
                    scores.add(score);

                    String data[][] = {{(String) names.get(i).toString(), (String) scores.get(i).toString()},
                    };
                    String column[] = {"Player's Name", "Score"};
                    JFrame f = new JFrame("Table Java");


                    final JTable jt = new JTable(data, column);
                    jt.setCellSelectionEnabled(true);
                    ListSelectionModel select = jt.getSelectionModel();
                    select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    select.addListSelectionListener(new ListSelectionListener() {
                        public void valueChanged(ListSelectionEvent e) {
                            String Data = null;
                            int[] row = jt.getSelectedRows();
                            int[] columns = jt.getSelectedColumns();
                            for (int i = 0; i < row.length; i++) {
                                for (int j = 0; j < columns.length; j++) {
                                    Data = (String) jt.getValueAt(row[i], columns[j]);
                                }
                            }
                            System.out.println("Table element selected is: " + Data);
                        }
                    });
                    JScrollPane sp = new JScrollPane(jt);
                    f.add(sp);
                    f.setSize(300, 200);
                    f.setVisible(true);
                    f.setLocation(200, 300);
                }

            });


            f.add(b);
            f.add(tf);
            f.add(labelM);
            f.setLocation(500, 100);
            f.setSize(400, 200);
            f.setLayout(null);
            f.setVisible(true);


            Frame ef = new Frame(" Example");
            ef.setSize(350, 700);
            ef.setVisible(true);
            ef.setResizable(false);
            ef.setLayout(null);/*like packing for table*/
            ef.setLocation(500, 300);

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
            ef.add(b2);
            ef.add(b1);


            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //ddd = false;
                    // animate = new Animate(this);
                    thread = new Thread(animate);
                    System.out.println(thread.getState());
                    thread.start();
                }
            });
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    System.exit(0);


                }
            });

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
/*
            super.paintComponent(g);
            revalidate(g);
            repaint(g);
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();*/

        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && (paddle.x > 0)) {

            paddle.x -= 20;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < getWidth() - paddle.width) {
            paddle.x += 20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


/*  public void methodofinding() {
        //for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(1); stop>System.nanoTime();) {
       *//* long startTime = System.currentTimeMillis();
        long endTime = startTime + (5 * 1000); // this is for 5 sec
        do {
        } while (System.currentTimeMillis() < endTime);*//*

    }*/
/*// Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableExamples {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    JTableExamples()
    {
        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("JTable Example");

        // Data to be displayed in the JTable
        String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
        };

        // Column Names
        String[] columnNames = { "Name", "Roll Number", "Department" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }

    // Driver  method
    public static void main(String[] args)
    {
        new JTableExamples();
    }
} */
// Initializing the JTable
             /*          for (int i=0;i<scoreArray.length;i++) {
                            for (int j=0;j<scoreArray[0].length;j++) {

                                scoreArray[i][j] ={,}
                } };

   if (striken >= 20) {
                        ext = ext + 100;
                        //  repaint(paddle.width);
                        repaint();
                    }*/

