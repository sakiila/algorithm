//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 733 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 37 解数独
 * 2021-01-18 11:12:25
 * 思路： 回溯
 */
public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            helper(board, 0, 0);
        }

        boolean helper(char[][] board, int row, int col) {
            // 行遍历完了，则返回成功
            if (row == board.length) {
                return true;
            }
            // 列遍历完了，则换下一行
            if (col == board.length) {
                return helper(board, row + 1, 0);
            }
            // 跳过，去到下一列
            if (board[row][col] != '.') {
                return helper(board, row, col + 1);
            }
            // 尝试填充字符
            for (char i = '1'; i <= '9'; i++) {
                if (!isValid(board, row, col, i)) {
                    continue;
                }
                board[row][col] = i;
                if (helper(board, row, col)) {
                    return true;
                }
                board[row][col] = '.';
            }
            return false;
        }

        boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == c) {
                    return false;
                }
                if (board[row][i] == c) {
                    return false;
                }
                //  i/3定位到行，i%3定位到列
                if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}