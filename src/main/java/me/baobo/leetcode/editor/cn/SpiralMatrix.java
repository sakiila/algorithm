//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 635 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 螺旋矩阵
 * 2021-03-15 07:58:39
 * 思路：两角定位法
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int rows = matrix.length, cols = matrix[0].length;
            if (matrix == null || rows == 0 || cols == 0) {
                return list;
            }

            int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int col = left; col <= right; col++) {
                    list.add(matrix[top][col]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    list.add(matrix[row][right]);
                }
                // 如果只有一列或一行数据，不加判断则会出错
                if (left < right && top < bottom) {
                    for (int col = right - 1; col > left; col--) {
                        list.add(matrix[bottom][col]);
                    }
                    for (int row = bottom; row > top; row--) {
                        list.add(matrix[row][left]);
                    }
                }
                top++;
                bottom--;
                left++;
                right--;
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}