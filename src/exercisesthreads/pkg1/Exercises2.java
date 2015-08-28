/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisesthreads.pkg1;

/**
 *
 * @author RolfMoikjær
 */

//Inden problemet er løst kan der komme ulige tal, samt der kan være lige tal
//som metoden even.next() springer over.
//Efter vi har synchronized even.next() metoden, kører det fint og der kommer
//kun lige tal.
//Det er ikke særligt tit at den fejlede.
public class Exercises2 {

    static Even even = new Even();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
    
    public static class Even {

        private int n = 0;

        public synchronized int next() {
            n++;
            n++;
            return n;
        }
    }

    public static class Thread1 extends Thread {

        public void run() {
            int numb;
            int numb2;

            for (int i = 0; i < 500; i++) {
                numb2 = even.next();
                numb = numb2 % 2;

                if (numb == 0) {
                    System.out.println(numb2);
                }
            }
        }
    }

    public static class Thread2 extends Thread {

        public void run() {
            int numb;
            int numb2;

            for (int i = 0; i < 500; i++) {
                numb2 = even.next();
                numb = numb2 % 2;
                if (numb == 0) {
                    System.out.println(numb2);
                }
            }
        }
    }
}
