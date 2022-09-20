//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学 
// 👍 219 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 149 直线上最多的点数
 * 2021-02-15 10:37:49
 * 思路：Map
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            if (points.length < 3) {
                return points.length;
            }
            int res = 0;
            //遍历每个点
            for (int i = 0; i < points.length; i++) {
                int duplicate = 0;
                int max = 0;//保存经过当前点的直线中，最多的点
                HashMap<String, Integer> map = new HashMap<>();
                for (int j = i + 1; j < points.length; j++) {
                    //求出分子分母
                    int x = points[j][0] - points[i][0];
                    int y = points[j][1] - points[i][1];
                    if (x == 0 && y == 0) {
                        duplicate++;
                        continue;
                    }
                    //进行约分
                    int gcd = gcd(x, y);
                    x = x / gcd;
                    y = y / gcd;
                    // 分子 + "@" + "分母" 作为 key
                    String key = x + "@" + y;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
                //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
                res = Math.max(res, max + duplicate + 1);
            }
            return res;
        }

        // 最大公约数
        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}