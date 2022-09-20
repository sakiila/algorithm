//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 217 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 697 数组的度
 * 2021-02-20 07:11:32
 * 思路：滑动窗口
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            int n = nums.length, degree = 0;
            Map<Integer, Integer> map = new HashMap<>();
            // 计算原数组的频数
            for (int i = 0; i < n; i++) {
                degree = Math.max(degree, map.merge(nums[i], 1, Integer::sum));
            }

            map.clear();

            int left = 0, right = 0, curDegree = 0, res = n;
            while (right < n) {
                // 计算当前滑窗内子数组的频数
                curDegree = Math.max(curDegree, map.merge(nums[right++], 1, Integer::sum));

                // 频数一致的情况
                if (curDegree == degree) {
                    while (map.merge(nums[left], -1, Integer::sum) != degree - 1) {
                        left++;
                    }
                    curDegree = degree - 1;
                    res = Math.min(res, right - left);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}