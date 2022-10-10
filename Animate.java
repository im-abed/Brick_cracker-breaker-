package com.company;

public class Animate implements Runnable {
    Blockcrapa bp;

    public boolean ddd ;

    Animate(Blockcrapa b) {
        bp = b;
      //  bc=c;

    }


    public void run() {

        while (true) {
            bp.update();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


