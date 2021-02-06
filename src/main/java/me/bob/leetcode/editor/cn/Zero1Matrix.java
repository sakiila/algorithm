//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [1,1,1]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 373 👎 0


package me.bob.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542 01 矩阵
 * 2021-02-06 10:43:25
 * 思路：BFS
 */
public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            Queue<int[]> queue = new LinkedList<>();
            int row = matrix.length, col = matrix[0].length;

            // 0全部入队，1的位置设为-1为未访问
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int x = temp[0], y = temp[1];
                for (int i = 0; i < 4; i++) {
                    int newx = x + dx[i];
                    int newy = y + dy[i];
                    if (newx >= 0 && newy >= 0 && newx < row && newy < col
                            && matrix[newx][newy] == -1) {
                        // 更新0周围邻接点的值
                        matrix[newx][newy] = matrix[x][y] + 1;
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }

            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}