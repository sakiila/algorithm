//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 851 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 34 在排序数组中查找元素的第一个和最后一个位置
 * 2021-02-16 10:13:12
 * 思路：两次 二分查找
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = {-1, -1};
            int n = nums.length;
            if (n == 0) {
                return res;
            }

            int firstPosition = findFirstPosition(nums, target);
            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    index = mid;
                    right = mid - 1; // 必须修改区间，否则无法推出循环
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return index;

        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    index = mid;
                    left = mid + 1; // 必须修改区间，否则无法推出循环
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return index;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}