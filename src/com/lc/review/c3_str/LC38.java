package com.lc.review.c3_str;

import org.junit.jupiter.api.Test;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 20:12
 */
public class LC38 {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder cur = new StringBuilder();
        //通过递归调用获取上一个数字的外观数列
        String pre = countAndSay(n-1);
        char[] chars = pre.toCharArray();
        int num = 1;
        char c = pre.charAt(0);
        for(int i = 1; i <= chars.length; i++) {
            if(i == chars.length) {
                cur.append((char)('0'+num));
                cur.append(c);
            }else {
                if(chars[i] == c) {
                    num++;
                }else {
                    cur.append((char)('0'+num));
                    cur.append(c);
                    c = chars[i];
                    num = 1;
                }
            }
        }
        return cur.toString();
    }

    @Test
    public void test() {
        System.out.println((char) 48);
    }
}
