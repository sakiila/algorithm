//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// 所有点都 互不相同 
// 
// Related Topics 哈希表 数学 
// 👍 127 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 447 回旋镖的数量
 * 2021-02-15 10:20:33
 * 思路：按距离存入map（注意Java的乘幂运算）
 */
public class NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new NumberOfBoomerangs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;

            for (int i = 0; i < points.length; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int key = distance(points[i], points[j]);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                for (int k : map.values()) {
                    if (k >= 2) {
                        res += k * (k - 1);
                    }
                }
            }
            return res;
        }

        private int distance(int[] x, int[] y) {
            return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}