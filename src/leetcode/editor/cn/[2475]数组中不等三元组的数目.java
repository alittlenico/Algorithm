package leetcode.editor.cn;//给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
//
// 
// 0 <= i < j < k < nums.length 
// nums[i]、nums[j] 和 nums[k] 两两不同 。 
// 
// 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。 
// 
// 
//
// 返回满足上述条件三元组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,2,4,3]
//输出：3
//解释：下面列出的三元组均满足题目条件：
//- (0, 2, 4) 因为 4 != 2 != 3
//- (1, 2, 4) 因为 4 != 2 != 3
//- (2, 3, 4) 因为 2 != 4 != 3
//共计 3 个三元组，返回 3 。
//注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,1,1]
//输出：0
//解释：不存在满足条件的三元组，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 55 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2475 {

    public int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
        }
        int cnt = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return cnt;
    }

//    public int unequalTriplets(int[] nums) {
//        int n = nums.length;
//        int res = 0;
//        Arrays.sort(nums);
//        for (int i = 0, j = 0;i < n;i = j) {
//            while (j < n && nums[i] == nums[j]) {
//                ++j;
//            }
//            res += i * (j - i) * (n - j);
//        }
//        return res;
//    }

//    public int unequalTriplets(int[] nums) {
//        int cnt = 0;
//        int n = nums.length;
//        for (int i = 0;i < n;++i) {
//            for (int j = i + 1;j < n;++j) {
//                if (nums[j] == nums[i]) continue;
//                for (int k = j + 1;k < n;++k) {
//                    if (nums[j] == nums[k] || nums[k] == nums[i]) continue;
//                    ++cnt;
//                }
//            }
//        }
//        return cnt;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
