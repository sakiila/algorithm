//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// 👍 165 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 498 对角线遍历
 * 2021-01-26 07:33:10
 * 思路：确定遍历次数，变更起始元素
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }

            int row = matrix.length;
            int col = matrix[0].length;

            int[] res = new int[row * col];
            int resIndex = 0;
            int count = row + col - 1;
            int m = 0;
            int n = 0;

            for (int i = 0; i < count; i++) {
                if (i % 2 == 0) {
                    // 右上方向
                    while (m >= 0 && n < col) {
                        res[resIndex] = matrix[m][n];
                        resIndex++;
                        m--;
                        n++;
                    }
                    if (n < col) {
                        m++;
                    } else {
                        m += 2;
                        n--;
                    }
                } else {
                    // 左下方向
                    while (m < row && n >= 0) {
                        res[resIndex] = matrix[m][n];
                        resIndex++;
                        m++;
                        n--;
                    }
                    if (m < row) {
                        n++;
                    } else {
                        m--;
                        n += 2;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}