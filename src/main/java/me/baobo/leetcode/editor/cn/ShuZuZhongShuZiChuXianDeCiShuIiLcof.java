//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 338 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.List;

/**
 * 剑指 Offer 56 - II 数组中数字出现的次数 II
 * 2022-05-10 10:42:07
 * 思路：DP
 */
public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);

            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
                dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.min(res, dp[n - 1][i]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}