//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 144 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 643 子数组最大平均数 I
 * 2021-02-04 10:49:40
 * 思路：双指针滑动窗口，返回结果时先乘 1.0 转为浮点数
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int left = 0, right = 0, total = 0, max = Integer.MIN_VALUE;

            while (right < nums.length) {
                while (right - left < k) {
                    total += nums[right];
                    right++;
                }
                max = Math.max(max, total);
                total -= nums[left];
                left++;
            }

            return 1.0 * max / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}