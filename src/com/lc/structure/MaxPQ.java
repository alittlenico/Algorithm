package com.lc.structure;

/**
 * @author liuyi
 * @version 1.0
 * @description: 优先队列二叉堆实现
 * @date 2022/11/3 22:10
 */
public class MaxPQ<Key extends Comparable<Key>> {

    int parent(int root) {
        return root / 2;
    }

    int left(int root) {
        return root * 2;
    }

    int right(int root) {
        return root * 2 + 1;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private Key[] pq;

    private int size = 0;

    public MaxPQ(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    public Key max() {
        return pq[1];
    }

    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public void swim(int pos) {
        while(pos > 1 && less(parent(pos), pos)) {
            swap(parent(pos), pos);
            pos = parent(pos);
        }
    }

    public void sink(int pos) {
        while(left(pos) <= size) {
            int max = left(pos);
            if(right(pos) <= size && less(max, right(pos))) {
                max = right(pos);
            }
            if(less(max, pos)) break;
            swap(max, pos);
            pos = max;
        }
    }

    public void insert(Key e) {
        size++;
        pq[size] = e;
        swim(size);
    }

    public Key delMax() {
        Key max = pq[1];
        swap(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return max;
    }
}
