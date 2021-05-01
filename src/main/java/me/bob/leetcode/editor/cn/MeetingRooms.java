//给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判
//断一个人是否能够参加这里面的全部会议。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti < endi <= 106 
// 
// Related Topics 排序 
// 👍 66 👎 0


package me.bob.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252 会议室
 * 2021-05-01 20:12:14
 * 思路：排序后比较
 */
public class MeetingRooms {
    public static void main(String[] args) {
        Solution solution = new MeetingRooms().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i - 1][1] > intervals[i][0]) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}