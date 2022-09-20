//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 761 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 64 最小路径和
 * 2021-01-21 09:50:44
 * 思路：dp 递推
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {

            int row = grid.length;
            int col = grid[0].length;
            int[][] res = new int[row][col];

            res[0][0] = grid[0][0];
            for (int i = 1; i < row; i++) {
                res[i][0] = res[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < col; j++) {
                res[0][j] = res[0][j - 1] + grid[0][j];
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                }
            }

            return res[row - 1][col - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}