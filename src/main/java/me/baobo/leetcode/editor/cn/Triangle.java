//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 672 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.List;

/**
 * 120 三角形最小路径和
 * 2021-01-16 08:40:25
 * 思路：dp
 */
public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal1(List<List<Integer>> triangle) {
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int[][] res = new int[m][n];
            res[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < m; i++) {
                res[i][0] = res[i - 1][0] + triangle.get(i).get(0);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < triangle.get(i).size(); j++) {
                    if (j == triangle.get(i).size() - 1) {
                        res[i][j] = res[i - 1][j - 1] + triangle.get(i).get(j);
                    } else {
                        res[i][j] = Math.min(res[i - 1][j - 1], res[i - 1][j]) + triangle.get(i).get(j);
                    }
                }
            }

            int num = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                num = Math.min(num, res[m - 1][j]);
            }
            return num;
        }

        Integer[][] memo;

        public int minimumTotal(List<List<Integer>> triangle) {
            memo = new Integer[triangle.size()][triangle.size()];
            return helper(triangle, 0, 0);
        }

        public int helper(List<List<Integer>> triangle, int i, int j) {
            if (i == triangle.size()) {
                return 0;
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            return memo[i][j] = Math.min(helper(triangle, i + 1, j), helper(triangle, i + 1, j + 1))
                    + triangle.get(i).get(j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}