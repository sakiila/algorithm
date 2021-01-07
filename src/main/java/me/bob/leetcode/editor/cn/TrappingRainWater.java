//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1923 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42 接雨水
 * 2021-01-07 16:36:38
 * 思路：
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int currIndex = stack.pop();

                    while (!stack.isEmpty() && height[stack.peek()] == height[currIndex]) {
                        stack.pop();
                    }

                    if (!stack.isEmpty()) {
                        int stackTop = stack.peek();
                        res += (Math.min(height[stackTop], height[i]) - height[currIndex]) * (i - stackTop - 1);
                    }
                }
                stack.push(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}