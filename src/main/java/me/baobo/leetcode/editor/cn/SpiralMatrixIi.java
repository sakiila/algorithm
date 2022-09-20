//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 322 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 59 螺旋矩阵 II
 * 2021-03-16 07:07:02
 * 思路：两角定位法，模拟循环
 */
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int index = 1;
            int[][] res = new int[n][n];
            int left = 0, right = n - 1, top = 0, bottom = n - 1;
            
            while (left <= right && top <= bottom) {
                for (int col = left; col <= right; col++) {
                    res[top][col] = index++;
                }
                for (int row = top + 1; row <= bottom; row++) {
                    res[row][right] = index++;
                }
                for (int col = right - 1; col >= left; col--) {
                    res[bottom][col] = index++;
                }
                for (int row = bottom - 1; row > top; row--) {
                    res[row][left] = index++;
                }
                left++;
                right--;
                top++;
                bottom--;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}