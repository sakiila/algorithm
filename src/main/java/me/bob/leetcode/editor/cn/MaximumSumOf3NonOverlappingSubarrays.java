//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。 
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
// Related Topics 数组 动态规划 👍 250 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 689 三个无重叠子数组的最大和
 * 2021-12-08 19:16:36
 * 思路：滑动窗口
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        Solution solution = new MaximumSumOf3NonOverlappingSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int[] ans = new int[3];
            int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
            int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
            int sum3 = 0, maxTotal = 0;
            for (int i = k * 2; i < nums.length; ++i) {
                sum1 += nums[i - k * 2];
                sum2 += nums[i - k];
                sum3 += nums[i];
                if (i >= k * 3 - 1) {
                    if (sum1 > maxSum1) {
                        maxSum1 = sum1;
                        maxSum1Idx = i - k * 3 + 1;
                    }
                    if (maxSum1 + sum2 > maxSum12) {
                        maxSum12 = maxSum1 + sum2;
                        maxSum12Idx1 = maxSum1Idx;
                        maxSum12Idx2 = i - k * 2 + 1;
                    }
                    if (maxSum12 + sum3 > maxTotal) {
                        maxTotal = maxSum12 + sum3;
                        ans[0] = maxSum12Idx1;
                        ans[1] = maxSum12Idx2;
                        ans[2] = i - k + 1;
                    }
                    sum1 -= nums[i - k * 3 + 1];
                    sum2 -= nums[i - k * 2 + 1];
                    sum3 -= nums[i - k + 1];
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}