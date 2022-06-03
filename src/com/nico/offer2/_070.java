package com.nico.offer2;

public class _070 {
    public static void main(String[] args) {
        _070 sol = new _070();
        sol.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int hi = n - 1;
        int lo = 0;
        int mid;
        while(lo < hi){
            mid = lo + (hi - lo + 1) >> 1;
            //左右两边找到nums[mid]出现的最大次序，若找不到直接返回
            if(mid + 1 < n && nums[mid] == nums[mid + 1]){//右边合法
                if((mid + 1) % 2 != 0){
                    lo = mid + 2;
                }else{
                    hi = mid - 1;
                }
            }else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                if(mid % 2 != 0){
                    lo = mid + 1;
                }else{
                    hi = mid - 2;
                }
            }else{
                return nums[mid];
            }
        }
        return -1;
    }
}
