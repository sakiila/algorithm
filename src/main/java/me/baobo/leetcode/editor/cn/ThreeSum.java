//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2869 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15 三数之和
 * 2021-01-06 16:13:25
 * 思路：排序 + 双指针
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return res;
                }

                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int num = nums[i] + nums[left] + nums[right];
                    if (num == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        left++;
                        right--;

                        // 去重
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (num > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
