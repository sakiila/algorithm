//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免
//会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// 0 <= starti < endi <= 106 
// 
// Related Topics 堆 贪心算法 排序 
// 👍 256 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 253 会议室 II
 * 2021-05-01 20:20:02
 * 思路：可以使用最小堆判断最早结束时间的会议室
 */
public class MeetingRoomsIi {
    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int i = solution.minMeetingRooms(intervals);
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms2(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }

            // 按开始时间排序
            Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

            // 记录每个房间最后的结束时间
            List<Integer> list = new ArrayList<>();
            list.add(intervals[0][1]);

            for (int i = 1; i < intervals.length; i++) {
                int thisStartTime = intervals[i][0];
                int thisEndTime = intervals[i][1];

                int minEndTime = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) < minEndTime) {
                        minEndTime = list.get(j);
                        minIndex = j;
                    }
                }

                // 如果最小的结束时间小于等于当前的开始时间，则删除它
                if (minEndTime <= thisStartTime) {
                    list.remove(minIndex);
                }
                list.add(thisEndTime);

            }

            return list.size();
        }

        public int minMeetingRooms(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }

            // 按开始时间排序
            Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

            // 最小堆
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.offer(intervals[0][1]);
            for (int i = 1; i < intervals.length; i++) {
                int thisStartTime = intervals[i][0];
                int thisEndTime = intervals[i][1];

                if (queue.peek() <= thisStartTime) {
                    queue.poll();
                }
                queue.offer(thisEndTime);
            }

            return queue.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}