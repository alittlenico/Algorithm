package com.nico;

public class Solution {
    public static void main(String[] args) {
        //16,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]

//        int[][] array = {};
//        if(array.length!=0){
//            int row = array.length;
//            int column = array[0].length;
//            for(int i=0;i<row;i++){
//                for(int j=0;j<column;j++)
//                    System.out.print(array[i][j]+"\t");
//                System.out.println();
//            }
//            boolean result = Find(16,array);
//            System.out.println(result);
//        }
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find1(16,array));

    }
    public static boolean Find(int target, int[][] array) {//暴力解
        //判空
        if(array.length==0||array[0].length==0) return false;
        int row = array.length;
        int column = array[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++)
                if(target==array[i][j])
                    return true;
        }
        return false;
    }

    public static boolean Find1(int target,int[][] array){//二分法
        if(array.length==0||array[0].length==0) return false;
        int row = array.length;
        int column = array[0].length;
        int i=0;
        int j=column-1;
        while (j>=0&&i<=(row-1)){
            int val = array[i][j];
            if(target == val) return true;
            else if(target < val)
                j--;
            else
                i++;
        }
        return false;
    }
}
