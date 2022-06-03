package com.nico.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _524 {

    public static void main(String[] args) {
        _524 sol = new _524();
        sol.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea"));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        s = " " + s;
        int length = s.length();
        int[][] next = new int[length][];

        int[] lastArr = new int[26];
        Arrays.fill(lastArr,-1);
        next[length - 1] = lastArr;

        for (int i = length - 2; i >= 0; i--) {
            int[] currentArr = new int[26];
            System.arraycopy(lastArr, 0, currentArr, 0, 26);
            currentArr[s.charAt(i + 1) - 'a'] = i + 1;
            lastArr = next[i] = currentArr;
        }

        String result = "";
        for (String word : dictionary) {
            if (isSubsequence(word, next)) {
                if (word.length() > result.length()) result = word;
                else if (word.length() == result.length() && word.compareTo(result) < 0) result = word;
            }
        }
        return result;
    }

    private boolean isSubsequence(String word, int[][] next) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            p = next[p][word.charAt(i) - 'a'];
            if (p == -1) return false;
        }
        return true;
    }
}
