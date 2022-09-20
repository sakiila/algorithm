//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 834 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 169 多数元素
 * 2021-01-11 15:04:55
 * 思路：摩尔投票法
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int res = 0;

            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    res = nums[i];
                }
                count = res == nums[i] ? count + 1 : count - 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}