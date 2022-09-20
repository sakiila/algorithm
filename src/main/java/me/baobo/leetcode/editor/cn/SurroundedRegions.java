//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 780 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 130 被围绕的区域
 * 2022-04-28 08:10:16
 * 思路：DFS
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                dfs(board, i, 0, m, n);
                dfs(board, i, n - 1, m, n);
            }
            for (int j = 0; j < n; j++) {
                dfs(board, 0, j, m, n);
                dfs(board, m - 1, j, m, n);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j, int m, int n) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (board[i][j] == 'O') {
                board[i][j] = 'A';
            } else {
                return;
            }
            dfs(board, i - 1, j, m, n);
            dfs(board, i + 1, j, m, n);
            dfs(board, i, j - 1, m, n);
            dfs(board, i, j + 1, m, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}