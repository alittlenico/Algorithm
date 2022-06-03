package com.nico.leetcode.source210;


/**
 * 如果给定的是7位，范围是-64-63，当输入-64,可以反转为-46,这就不会溢出吗,
 * 作者是先把所有数都转为正数来处理，所有对于最小负数，取反后肯定会超范围，
 * 但不代表这个数不能反转，因为题目中是32位，-2^31=-2 147 483 648,所以它反转后肯定溢出，应而能通过测试用例。
 *
 * -2 147 483 648 - 2 147 483 647
 */
public class _005ReverseInteger {
    static int MIN = -64;
    static int MAX = 63;
    /**
     * -64-63
     * @param x
     * @return
     */
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        int neg = x<0 ? -1 : 1;
        x *= neg;
        int ret = 0;
        /**
         *
         */
        while (x > 0){
            int n = ret;
            n *= 10;
            n += x%10;
            x /= 10;
            //溢出
            if(n/10 != ret) return 0;
            ret = n;
        }
        return ret * neg;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            /**
             * integer范围 [-2 147 483 648 , 2 147 483 647]
             * 取7 和 -8是因为尾数
             */
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {

        _005ReverseInteger ri = new _005ReverseInteger();
        System.out.println(ri.reverse2(-58));
//        System.out.println(ri.reverse(-64));
    }
}
