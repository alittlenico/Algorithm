package com.lc.review.c5_number;

/**
 * @author liuyi
 * @version 1.0
 * @description: 9. 回文数
 * @date 2022/6/24 14:41
 */
public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int n = 0;
        while (x > n) {
            n *= 10;
            n += x % 10;
            x /= 10;
        }
        return (x == n || n / 10 == x);
    }
}
