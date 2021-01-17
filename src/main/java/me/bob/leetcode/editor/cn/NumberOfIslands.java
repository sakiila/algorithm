//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 938 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 200 岛屿数量
 * 2021-01-17 12:16:06
 * 思路：并查集
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] parent;
        int count;

        public int numIslands(char[][] grid) {
            int p = grid.length;
            int q = grid[0].length;
            parent = new int[p * q];
            count = 0;
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < q; j++) {
                    parent[i * q + j] = i * q + j;
                }
            }

            for (int i = 0; i < p; i++) {
                for (int j = 0; j < q; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        if (i + 1 < p && grid[i + 1][j] == '1') {
                            union(i * q + j, (i + 1) * q + j);
                        }
                        if (j + 1 < q && grid[i][j + 1] == '1') {
                            union(i * q + j, i * q + j + 1);
                        }
                    }
                    grid[i][j] = '0';
                }
            }

            return count;
        }

        public void union(int p, int q) {
            int a = find(p);
            int b = find(q);
            if (a != b) {
                parent[a] = b;
                count--;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}