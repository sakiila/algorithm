//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 543 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 994 腐烂的橘子
 * 2022-04-28 08:59:19
 * 思路：BFS
 */
public class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int fresh = 0, time = 0;
            Queue<int[]> queue = new ArrayDeque<>();

            // 定义4个方向的位移
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        // 烂橘子加入队列
                        queue.add(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            if (fresh == 0) {
                return 0;
            }

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int[] cell = queue.poll();
                    // 每次从当前的所有烂橘子向其四周开始腐烂一次
                    for (int d = 0; d < 4; d++) {
                        int mx = cell[0] + dx[d];
                        int my = cell[1] + dy[d];
                        if (mx >= 0 && my >= 0 && mx < m && my < n && grid[mx][my] == 1) {
                            grid[mx][my] = 2;
                            queue.add(new int[]{mx, my});
                            fresh--;
                        }
                    }
                }
                time++;
            }

            return fresh == 0 ? time - 1 : -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}