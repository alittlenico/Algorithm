package com.nico.leetcode.source210;

public class _23CountAndSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if(n == 1) return "1";
        String str = countAndSay(n - 1);
        char[] arr = str.toCharArray();
        char current = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(current == arr[i]){
                ++count;
            }else{//已到达下一个字符串区间
                sb.append(count+"");
                sb.append(current+"");
                current = arr[i];
                count = 1;
            }
        }
        sb.append(count+"");
        sb.append(current+"");
        return sb.toString();
    }

    public String countAndSay2(int n) {
        if(n == 1) return "1";
        String[] results = new String[n];//存放对应 1 到 n对应的countAndSay的值
        results[0] = "1";//n = 1时的值
        for(int i = 1;i < n;i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            String str = results[i-1];
            char current = str.charAt(0);
            for(int j = 0;j < str.length();j++){
                if(current == str.charAt(j)){
                    ++count;
                }else{//已到达下一个字符串区间
                    sb.append(count+"");
                    sb.append(current+"");
                    current = str.charAt(j);
                    count = 1;
                }
            }
            sb.append(count+"");
            sb.append(current+"");
            results[i] = sb.toString();
        }
        return results[n-1];
    }

    public String countAndSay3(int n) {
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

    public String countAndSay4(int n) {
        if(n == 1) return "1";
        String[] results = new String[n];//存放对应 1 到 n对应的countAndSay的值
        results[0] = "1";//n = 1时的值
        for(int i = 1;i < n;i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String str = results[i-1];
            char[] arr = str.toCharArray();
            char current = arr[0];
            for(int j = 1;j < arr.length;j++){
                if(current == arr[j]){
                    ++count;
                }else{//已到达下一个字符串区间
                    sb.append(count+"");
                    sb.append(current+"");
                    current = arr[j];
                    count = 1;
                }
            }
            sb.append(count+"");
            sb.append(current+"");
            results[i] = sb.toString();
        }
        return results[n-1];
    }

    public static void main(String[] args) {
        _23CountAndSay sol = new _23CountAndSay();
        System.out.println(sol.countAndSay(4));

    }
}
