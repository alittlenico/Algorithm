package leetcode.editor.cn;//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1220 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution128 {
    public int longestConsecutive(int[] nums) {
        //用hash表记录每个数 和包含它的连续区间
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int len = nums.length;
        for(int x : nums) {
            //如果当前元素没有被遍历
            if(!map.containsKey(x)) {
                Integer leftLen = map.getOrDefault(x - 1, 0);
                Integer rightLen = map.getOrDefault(x + 1, 0);
                int curLen = leftLen+rightLen+1;
                ans = Math.max(ans,curLen);
                map.put(x,-1);
                map.put(x-leftLen,curLen);
                map.put(x+rightLen,curLen);
            }
        }
        return ans;
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        sol.longestConsecutive(new int[]{0,-1});
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
