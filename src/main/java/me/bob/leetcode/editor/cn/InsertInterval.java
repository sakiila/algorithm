//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 356 👎 0


package me.bob.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 57 插入区间
 * 2021-01-25 09:52:07
 * 思路：先判断左边区间，再合并，最后放右边区间
 */
public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] res = new int[intervals.length + 1][2];
            int idx = 0;
            int i = 0;
            // 首先将新区间左边且相离的区间加入结果集
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                res[idx++] = intervals[i++];
            }
            // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            // 将最终合并后的新区间加入结果集
            res[idx++] = newInterval;
            // 最后将新区间右边且相离的区间加入结果集
            while (i < intervals.length) {
                res[idx++] = intervals[i++];
            }
            return Arrays.copyOf(res, idx);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}