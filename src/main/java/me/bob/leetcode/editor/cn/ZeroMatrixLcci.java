//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 22 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 面试题 01.08 零矩阵
 * 2021-01-26 07:24:21
 * 思路：使用两个数组分别存储行与列的0
 */
public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int row = matrix.length;
            int col = matrix[0].length;
            int[] a = new int[row];
            int[] b = new int[col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        a[i] = 1;
                        b[j] = 1;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (a[i] == 1 || b[j] == 1) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}