package com.company;

import java.awt.event.ActionListener;

public class Animate2 implements Runnable {
    Blockcrapa bz;

    public boolean ddd ;

    Animate2(Blockcrapa b) {
        bz=b;
        //  bc=c;

    }

    public void run() {

        while (true) {
            bz.update();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
