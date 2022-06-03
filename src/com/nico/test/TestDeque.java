package com.nico.test;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/01/22/19:00
 * @Description:
 */
public class TestDeque {

    @Test
    public void test() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(null);
        deque.add(4);
        while (!deque.isEmpty()){
            System.out.println(deque.remove());
        }
    }

}
