//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 两个网格块属于同一 连通分量 需满足下述全部条件： 
//
// 
// 两个网格块颜色相同 
// 在上、下、左、右任意一个方向上相邻 
// 
//
// 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块： 
//
// 
// 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻 
// 在网格的边界上（第一行/列或最后一行/列） 
// 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 116 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 1034 边界着色
 * 2021-12-07 21:08:39
 * 思路：DFS
 */
public class ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new ColoringABorder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n, c;
        int[][] grid, ans;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int[][] colorBorder(int[][] _grid, int row, int col, int color) {
            grid = _grid;
            c = color;
            m = grid.length;
            n = grid[0].length;
            ans = new int[m][n];
            dfs(row, col);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][j] == 0) {
                        ans[i][j] = grid[i][j];
                    }
                }
            }
            return ans;
        }

        void dfs(int x, int y) {
            int cnt = 0;
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                } else {
                    cnt++;
                }
                if (ans[nx][ny] != 0) {
                    continue;
                }
                ans[nx][ny] = -1;
                dfs(nx, ny);
            }
            ans[x][y] = cnt == 4 ? grid[x][y] : c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}