//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 243 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 剑指 Offer 42 连续子数组的最大和
 * 2021-04-08 06:36:50
 * 思路：动态规划
 */
public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, max = nums[0];
            for (int x : nums) {
                pre = Math.max(x, pre + x);
                max = Math.max(max, pre);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}