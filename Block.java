package com.company;

import javax.tools.Tool;
import java.awt.*;

public class Block extends Rectangle {
    public boolean ddd = false;

    Image pic;
    double dx = 5;
    double dy = -5;
    boolean washit = false;
    boolean nagboo = false;
    boolean nagboo2 = false;
    boolean levelindic = false;
    Rectangle left, right;
    Graphics g;

    Block(int a, int b, int w, int h, String s) {
        x = a;
        y = b;
        width = w;
        height = h;
        pic = Toolkit.getDefaultToolkit().getImage(s);
        left = new Rectangle(a - 1, b, 1, h);
        right = new Rectangle(a + w + 1, b, 1, h);

    }

    public void draw(Graphics g, Component c) {
        if (washit == false) {
            g.drawImage(pic, x, y, width, height, c);
        }
    }

    public void redraw(Graphics g, Component c) {

        if (washit == false) {
            g.drawImage(pic, x, y, width, height, c);
        }
    }

}
