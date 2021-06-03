//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 278 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 525 连续数组
 * 2021-06-03 08:11:34
 * 思路：前缀和 + 哈希表
 */
public class ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            // 转换为求最长的连续子数组，其元素和为 0
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = -1;
                }
            }

            int[] sum = new int[nums.length + 1];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sum.length; i++) {
                if (map.containsKey(sum[i])) {
                    res = Math.max(res, i - map.get(sum[i]));
                } else {
                    map.put(sum[i], i);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}