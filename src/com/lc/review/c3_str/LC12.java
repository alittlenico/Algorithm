package com.lc.review.c3_str;

/**
 * @author liuyi
 * @version 1.0
 * @description: 12. 整数转罗马数字
 * @date 2022/6/24 15:13
 */
public class LC12 {
    class Solution {
        public String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < values.length;i++){
                while(num >= values[i]){
                    sb.append(symbols[i]);
                    num -= values[i];
                }
            }
            return sb.toString();
        }
    }
}
