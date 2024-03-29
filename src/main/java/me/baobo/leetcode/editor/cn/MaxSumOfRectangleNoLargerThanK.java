//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。 
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 队列 二分查找 动态规划 
// 👍 179 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.TreeSet;

/**
 * 363 矩形区域不超过 K 的最大数值和
 * 2021-04-22 07:22:49
 * 思路：前缀和 & 二分（抽象一维）
 */
public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;

            // 预处理前缀和
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }

            int ans = Integer.MIN_VALUE;
            // 遍历子矩阵的上边界
            for (int top = 1; top <= m; top++) {
                // 遍历子矩阵的下边界
                for (int bot = top; bot <= m; bot++) {
                    // 使用「有序集合」维护所有遍历到的右边界
                    TreeSet<Integer> ts = new TreeSet<>();
                    ts.add(0);
                    // 遍历子矩阵的右边界
                    for (int r = 1; r <= n; r++) {
                        // 通过前缀和计算 right
                        int right = sum[bot][r] - sum[top - 1][r];
                        // 通过二分找 left
                        Integer left = ts.ceiling(right - k);
                        if (left != null) {
                            int cur = right - left;
                            ans = Math.max(ans, cur);
                        }
                        // 将遍历过的 right 加到有序集合
                        ts.add(right);
                    }
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}