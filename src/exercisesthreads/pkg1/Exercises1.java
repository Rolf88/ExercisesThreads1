/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisesthreads.pkg1;

import static java.lang.Thread.sleep;

/**
 *
 * @author RolfMoikjær
 */
public class Exercises1 {

    static boolean hasEnded = false;

    public static class Thread1 extends Thread {

        long number = 0;

        public void run() {
            for (long i = 0; i < 1000000000; i++) {
                number += i;
            }
            System.out.println("E1 = " + number);
        }
    }

    public static class Thread2 extends Thread {

        public void run() {
            for (long i = 0; i < 5; i++) {

                try {
                    System.out.println("E2 = " + i);
                    sleep(2000);
                } catch (Exception e) {
                }
            }
        }
    }

    public static class Thread3 extends Thread {

        public void run() {

            for (long i = 10; i < 100000000; i++) {

                try {
                    if (!hasEnded) {
                        System.out.println("E3 =" + i);
                        sleep(3000);
                    }
                } catch (Exception e) {
                }
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
        try {
            sleep(10000);
            hasEnded = true;
        } catch (Exception e) {
        }
    }

}
