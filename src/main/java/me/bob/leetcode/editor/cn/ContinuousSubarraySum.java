//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数学 动态规划 
// 👍 259 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 523 连续的子数组和
 * 2021-06-02 09:29:04
 * 思路：前缀和 + 哈希表 + 同余定理
 * 同余定理： 如果两个整数 m、n 满足 n - m 能被 k 整除，那么 n 和 m 对 k 同余
 * sum[j + 1] % k == sum[i] % k，等价于 (sum[j + 1] - sum[i]) % k == 0
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            // 保存余数对应的下标
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sum.length; i++) {
                int sumMod = sum[i] % k;
                if (map.containsKey(sumMod) && i > map.get(sumMod) + 1) {
                    return true;
                } else if (!map.containsKey(sumMod)) {
                    map.put(sumMod, i);
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}