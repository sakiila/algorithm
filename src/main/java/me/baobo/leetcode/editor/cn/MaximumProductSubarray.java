//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1062 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 152 乘积最大子数组
 * 2021-04-24 07:04:43
 * 思路：动态规划
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1;
            for (int num : nums) {
                // 由于存在负数，那么会导致最大的变最小的，最小的变最大的
                // 如果当前数小于 0，则交换 imax 和 imin
                if (num < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                imax = Math.max(num, imax * num);
                imin = Math.min(num, imin * num);

                max = Math.max(max, imax);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}