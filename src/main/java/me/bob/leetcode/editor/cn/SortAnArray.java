//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 544 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 912 排序数组
 * 2022-04-23 10:24:39
 * 思路：快速排序
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int index = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < nums[right]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    index++;
                }
            }
            int temp = nums[right];
            nums[right] = nums[index];
            nums[index] = temp;
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}