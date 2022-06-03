package com.nico.leetcode;

public class Sort {
    public void sort(int[] array){
        int len = array.length;
        for(int i = 0;i < len-1;i++){
            for(int j = 1;j < len - i;j++){
                if(array[j-1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        for(int i = 0;i < len;i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Sort sol = new Sort();
        sol.sort(new int[]{5,4,3,2,1});
    }
}
