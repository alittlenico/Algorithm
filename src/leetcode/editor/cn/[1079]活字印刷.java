package leetcode.editor.cn;//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 计数 👍 237 👎 0


import java.sql.PreparedStatement;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1079 {


    //预处理组合数
    private static final int L = 8;
    private static final int[][] c = new int[L][L];

    static {
        for (int i = 0;i < L;++i) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1;j < i;++j) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            count.put(c, count.getOrDefault(c,0 ) + 1);
        }
        int m = count.size();int n = tiles.length();
        //f[i][j] : 前i种字符构造长度为j的数目
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 1;
        int i = 1;
        //对于固定每一个j 第一层循环和第三层循环合起来的复杂度是o(n)
        for (var cnt : count.values()) {//枚举每种字符
            for (int j = 0;j <= n;++j) {//长度
                for (int k = 0;k <=j && k <= cnt;k++) {//每种字符可选k个
                    f[i][j] += f[i-1][j-k] * c[j][k];
                }
            }
            i++;
        }
        int res = 0;
        //把长度为1到n的结果求和
        for (int j = 1;j <= n;++j) {
            res += f[m][j];
        }
        return res;
    }


//    //存储了字母序列
//    List<String> list = new ArrayList<>();
//    public int numTilePossibilities(String tiles) {
//        Map<Character, Integer> count = new HashMap<>();
//        for (char t : tiles.toCharArray()) {
//            count.put(t, count.getOrDefault(t,0 ) + 1);
//        }
//        Set<Character> set = new HashSet<>(count.keySet());
//
//        //减去空集的情况
//        dfs("",tiles.length(), count, set);
//        return list.size() - 1;
//    }
//
//    /**
//     * 外层res=1 代表空集,内层代表记录当前不继续加字符的情况
//     * @param i
//     * @param count
//     * @param set
//     * @return
//     */
//    public int dfs(String cur, int i, Map<Character, Integer> count, Set<Character> set) {
//        if (i == 0) {
//            list.add(cur);
//            return 1;
//        }
//        int res = 1;
//        list.add(cur);
//        for (char t : set) {
//            if (count.get(t) > 0) {
//                count.put(t, count.get(t) - 1);
//                res += dfs(cur + t,i - 1, count, set);
//                count.put(t, count.get(t) + 1);
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.numTilePossibilities("AAB");
//        System.out.println(s.list);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
