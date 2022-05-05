//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 775 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 56 合并区间
 * 2021-01-25 09:06:41
 * 思路：先排序，再合并
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Deque<int[]> res = new ArrayDeque<>();
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] curr = intervals[i];
                int[] last = res.getLast();
                if (last[1] >= curr[0]) {
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    res.add(curr);
                }
            }
            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}