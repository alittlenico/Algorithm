package com.nico.offer2;

public class _011 {
    public static void main(String[] args) {
        _011 sol = new _011();
        sol.minArray(new int[]{2,2,2,0,1});
    }
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int lo = 0;int hi = n - 1;int mid = lo + (hi - lo + 1) >> 1;
        while(lo < hi){
            mid = lo + (hi - lo + 1) >> 1;
            if(numbers[mid] > numbers[hi]){
                lo = mid + 1;
            }else if(numbers[mid] < numbers[hi]){
                hi = mid;
            }else{
                --hi;
            }
        }
        return numbers[hi];
    }
}
