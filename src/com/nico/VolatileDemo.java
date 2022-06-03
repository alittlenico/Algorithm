package com.nico;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/05/26/17:23
 * @Description:
 */
public class VolatileDemo {
      private static boolean ready;
      private static int number;
      private static class ReaderThread extends Thread {
          @Override
          public void run() {
                         while(!ready) {
                                 Thread.yield();
                             }
                         System.out.println(number);
                     }
     }
     public static void main(String[] args) {
                 new ReaderThread().start();
                 number = 42;
                 ready = true;
             }
 }
