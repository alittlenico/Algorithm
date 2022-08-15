package com.lc.review.c6_dfs;
import java.util.*;
/**
 * @author liuyi
 * @version 1.0
 * @description: 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/8/15 12:01
 */
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //最暴力
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs) {
            //字符串排序
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            List<String> temp = map.getOrDefault(sortedStr,new ArrayList<String>());
            temp.add(str);
            map.put(sortedStr,temp);
        }
        List<List<String>> ans = new ArrayList<>();
        //遍历map收集
        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
