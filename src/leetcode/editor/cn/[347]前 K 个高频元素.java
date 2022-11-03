package leetcode.editor.cn;//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1201 👎 0


//import org.omg.CORBA.INTERNAL;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }
        PriorityQueue<Integer> minHead = new PriorityQueue<>(((o1, o2) -> {
            return map.get(o1) - map.get(o2);
        }));
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        for(int i = 0;i < entries.size(); ++i) {
            int val = entries.get(i).getKey();
            //不足k直接入小顶堆
            if(i < k) {
                minHead.add(val);
            }else {
                Integer peek = minHead.peek();
                if (peek != null && map.get(peek) < map.get(val)) {
                    minHead.poll();
                    minHead.add(val);
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0;i < k; ++i) {
            res[i] = minHead.poll();
        }
        return res;
    }

    private void headSort(int[] arr,int len) {
//        buildMinHead(arr, len);
//        for()
    }

    private void buildMinHead(int[] arr, int len) {
        for(int i = len / 2 - 1;i >= 0;--i) {
            headAdjust(arr, i, len);
        }
    }

    private void headAdjust(int[] arr, int k, int len) {
        int temp = arr[k];
        for(int i = 2 * k;i < len; i *= 2) {
            if(i < len - 1 && arr[i] > arr[i + 1]) {
                ++i;
            }
            if (temp <= arr[i]) break;
            else {
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
