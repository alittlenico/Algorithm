package leetcode.editor.cn;//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1051 👎 0


import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution581 {

//    public int findUnsortedSubarray(int[] nums) {
//
//    }

    //规律 [A B C] A中任意元素均小于B、C元素 找B左边界
    // A、B任意元素小于C 找B右边界
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int left = -1;int right = -1;
        int n = nums.length;
        for (int i = 0;i < n;++i) {
            if (max > nums[i]) {
                right = i;
            }
            if (min < nums[n - 1 - i]) {
                left = n - 1 - i;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
        }
        if (left == -1) return 0;
        return right - left + 1;
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        System.out.println(sol.findUnsortedSubarray1(new int[]{2, 6, 4, 8, 10, 9, 15}));
//    }

    // o(nlogn)
//    public int findUnsortedSubarray1(int[] nums) {
//        //排序
//        int n = nums.length;
//        int[] nums_ = new int[n];
//        for (int i = 0;i < n;++i) {
//            nums_[i] = nums[i];
//        }
//        Arrays.sort(nums_);
//        int left = 0,right = 0;
//        //左边界
//        for (int i = 0;i < n;++i) {
//            if (nums[i] != nums_[i]) {
//                left = i;
//                break;
//            }
//        }
//        //右边界
//        for (int i = n-1;i >= 0;--i) {
//            if (nums[i] != nums_[i]) {
//                right = i;
//                break;
//            }
//        }
//        return left == right ? 0 : right - left + 1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
