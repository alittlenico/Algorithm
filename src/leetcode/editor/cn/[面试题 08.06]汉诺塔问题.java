package leetcode.editor.cn;//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制: (1) 每次只能移动一个盘子; (2) 盘子只能从柱子顶端滑出移到下一根柱子; (3) 盘子只能叠在比它大的盘
//子上。 
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。 
//
// 你需要原地修改栈。 
//
// 示例1: 
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
// 
//
// 示例2: 
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
// 
//
// 提示: 
//
// 
// A中盘子的数目不大于14个。 
// 
//
// Related Topics 递归 数组 👍 211 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanotaMethod(A, B, C, A.size());
    }

    public void hanotaMethod(List<Integer> a, List<Integer> b, List<Integer> c, int size) {
        if (size == 1) {
            Integer remove = a.remove(a.size() - 1);
            c.add(remove);
            return;
        }
        hanotaMethod(a, c ,b, size - 1);
        Integer remove = a.remove(a.size() - 1);
        c.add(remove);
        hanotaMethod(b, a , c, size - 1);
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(2);
//        a.add(1);
//        a.add(0);
//        ArrayList<Integer> b = new ArrayList<>();
//        ArrayList<Integer> c = new ArrayList<>();
//        sol.hanota(a, b, c);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
