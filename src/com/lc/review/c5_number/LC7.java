package com.lc.review.c5_number;

/**
 * @author liuyi
 * @version 1.0
 * @description: 整数反转
 * @date 2022/6/24 11:32
 */
public class LC7 {

    /**
     * 不太方便理解
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            /**
             * integer范围 [-2 147 483 648 , 2 147 483 647]
             * 取7 和 -8是因为尾数
             */
            if (rev > Integer.MAX_VALUE / 10) return 0;
            if (rev < Integer.MIN_VALUE / 10) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 反转到最大或最小数的十分之1时，就要提前判断有没有溢出
     * 举个栗子：res >
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
