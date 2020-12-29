package com.nico.leetcode;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *  
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {

    public boolean solution1(int x){
        if(x<0) return false;
        String str = Integer.toString(x);
        char[] chars = str.toCharArray();
        int len = chars.length;
        for(int i=0;i<len/2;i++){
            char temp = chars[i];
            chars[i] = chars[len-1-i];
            chars[len-1-i] = temp;
        }
        return String.valueOf(chars).equals(str);
    }

    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0&&x%10==0)) return false;
        int n = 0;
        while(x>n){
            n *= 10;
            n += x%10;
            x /= 10;
        }
        return (x==n || n/10 == x);
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(12321));
        System.out.println(pn.isPalindrome(123321));
        System.out.println(pn.isPalindrome(1234521));
    }
}
