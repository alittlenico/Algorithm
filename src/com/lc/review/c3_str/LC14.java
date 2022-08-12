package com.lc.review.c3_str;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/6/28 17:28
 */
public class LC14 {

    //前缀为所有字符串都有
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        //前缀初始设定为第一个串
        String prefix = strs[0];
        for (String str : strs) {
            if (str.length() == 0 || prefix.length() == 0) return "";
            //前缀在当前字符的索引不为0 则不断缩减前缀的长度
            while (str.indexOf(prefix) != 0) prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }
}
