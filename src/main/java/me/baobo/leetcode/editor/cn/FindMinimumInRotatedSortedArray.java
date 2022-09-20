//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 334 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 153 寻找旋转排序数组中的最小值
 * 2021-01-29 17:40:40
 * 思路：二分搜索
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int i = 0, j = nums.length - 1;

            while (i < j) {
                int mid = (i + j) / 2;
                if (nums[mid] < nums[j]) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }

            return nums[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}