//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 783 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239 滑动窗口最大值
 * 2021-01-07 17:28:24
 * 思路：单调队列
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] arr = new int[nums.length - k + 1];
            Deque<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < nums.length; i++) {
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.addLast(i);

                // peek()的下标 如果不在窗口内，则弹出
                if (queue.peek() < i - k + 1) {
                    queue.poll();
                }

                // 当i遍历到窗口右边时，保存最大值
                if (i + 1 >= k) {
                    arr[i + 1 - k] = nums[queue.peek()];
                }
            }

            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}