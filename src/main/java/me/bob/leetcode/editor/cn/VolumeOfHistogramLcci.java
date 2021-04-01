//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 67 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 17.21 直方图的水量
 * 2021-04-02 06:22:04
 * 思路：单调栈
 */
public class VolumeOfHistogramLcci {
    public static void main(String[] args) {
        Solution solution = new VolumeOfHistogramLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int widths = i - left - 1;
                    int heights = Math.min(height[left], height[i]) - height[top];
                    res += widths * heights;
                }
                stack.push(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}