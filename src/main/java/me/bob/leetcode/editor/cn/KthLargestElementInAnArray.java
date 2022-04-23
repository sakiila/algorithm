//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 881 👎 0


package me.bob.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 215 数组中的第K个最大元素
 * 2021-02-11 08:21:05
 * 思路：排序
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("kthLargest = " + kthLargest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
            return quickSort(nums, 0, nums.length - 1, k - 1);
        }

        private int quickSort(int[] nums, int left, int right, int k) {
//            if (left >= right) {
//                return 0;
//            }
            int pivot = partition(nums, left, right);
            System.out.println("pivot = " + pivot);
            System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
            if (pivot < k) {
                return quickSort(nums, pivot + 1, right, k);
            } else if (pivot > k) {
                return quickSort(nums, left, pivot - 1, k);
            } else {
                return nums[pivot];
            }
        }

        private int partition(int[] nums, int left, int right) {
            int index = left;
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[right]) {
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