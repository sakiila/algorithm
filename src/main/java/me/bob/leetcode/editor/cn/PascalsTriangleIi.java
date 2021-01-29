//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 221 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 杨辉三角 II
 * 2021-01-29 16:41:44
 * 思路：迭代
 */
public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<>();

            // 构造第0行
            res.add(1);
            if (rowIndex == 0) {
                return res;
            }
            // 构造第1行
            res.add(1);
            for (int i = 1; i < rowIndex; i++) {
                for (int j = 0; j < i; j++) {
                    // 将两数之和放到第j位，不要影响第j+1位
                    res.set(j, res.get(j) + res.get(j + 1));
                }
                res.add(0, 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}