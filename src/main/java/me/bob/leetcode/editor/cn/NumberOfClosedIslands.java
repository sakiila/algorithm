//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 129 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 1254 统计封闭岛屿的数目
 * 2022-04-28 07:45:13
 * 思路：DFS
 */
public class NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0, m, n); // 先遍历最左边的岛屿
                dfs(grid, i, n - 1, m, n); // 先遍历最右边的岛屿
            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j, m, n); // 先遍历最上边的岛屿
                dfs(grid, m - 1, j, m, n); // 先遍历最下边的岛屿
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j, m, n);
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j, int m, int n) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (grid[i][j] == 0) {
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