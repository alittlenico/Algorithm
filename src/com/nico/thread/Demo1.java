package com.nico.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo1 implements Callable<Integer> {
    public static void main(String[] args) {
        Demo1 callable1 = new Demo1();
        FutureTask<Integer> ft = new FutureTask<Integer>(callable1);
        for(int i = 0;i < 10000;i++){
            System.out.println(Thread.currentThread().getName()+"执行，i = "+i);
            if(i == 20){
                new Thread(ft,"callable线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }
}
