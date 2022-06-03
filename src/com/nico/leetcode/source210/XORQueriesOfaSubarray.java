package com.nico.leetcode.source210;

public class XORQueriesOfaSubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        xor[0] = 0;
        int[] result = new int[queries.length];
        for(int i = 0;i < arr.length;i++){
            xor[i+1] = xor[i] ^ arr[i];
        }
        for(int j = 0;j < queries.length;j++){
            int left = queries[j][0];
            int right = queries[j][1];
            if(left == right) {
                result[j] = arr[left];
                continue;
            }else{
                if(left == 0){
                    result[j] = xor[right + 1];
                }else{
                    result[j] = xor[left] ^ xor[right + 1];
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        XORQueriesOfaSubarray sol = new XORQueriesOfaSubarray();
        sol.xorQueries(new int[]{16},new int[][]{{0,0},{0,0},{0,0},{0,0}});
    }

}
