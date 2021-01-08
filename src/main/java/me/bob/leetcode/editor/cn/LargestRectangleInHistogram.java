//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1119 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84 柱状图中最大的矩形
 * 2021-01-07 12:26:13
 * 思路： 单调栈
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("solution = " + solution.largestRectangleArea(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int office(int[] heights) {
            int length = heights.length;

            int res = 0;
            for (int i = 0; i < length; i++) {
                int currHeight = heights[i];

                int left = i;
                while (left > 0 && heights[left - 1] >= currHeight) {
                    left--;
                }

                int right = i;
                while (right < length - 1 && heights[right + 1] >= currHeight) {
                    right++;
                }

                res = Math.max(res, (right - left + 1) * currHeight);
            }

            return res;
        }

        public int largestRectangleArea(int[] heights) {

            // 在左右维护一个哨兵，高度为 0
            int[] array = new int[heights.length + 2];
            System.arraycopy(heights, 0, array, 1, heights.length);

            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;

            // 从左向右遍历，递增栈
            for (int i = 0; i < array.length; i++) {
                while (!stack.isEmpty() && array[i] < array[stack.peek()]) {
                    int h = array[stack.pop()];
                    res = Math.max(res, h * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}