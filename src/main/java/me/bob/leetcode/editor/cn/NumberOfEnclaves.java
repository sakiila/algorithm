//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 166 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 1020 飞地的数量
 * 2022-04-28 07:55:05
 * 思路：DFS
 */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0, m, n); // 最左边
                dfs(grid, i, n - 1, m, n); // 最右边
            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j, m, n); // 最上边
                dfs(grid, m - 1, j, m, n); // 最下边
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j, int m, int n) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (grid[i][j] == 1) {
                grid[i][j] = 2;
            } else {
                return;
            }
            dfs(grid, i - 1, j, m, n);
            dfs(grid, i + 1, j, m, n);
            dfs(grid, i, j - 1, m, n);
            dfs(grid, i, j + 1, m, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}