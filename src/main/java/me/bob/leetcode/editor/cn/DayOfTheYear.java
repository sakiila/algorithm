//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。 
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。 
//
// 
//
// 示例 1： 
//
// 
//输入：date = "2019-01-09"
//输出：9
// 
//
// 示例 2： 
//
// 
//输入：date = "2019-02-10"
//输出：41
// 
//
// 示例 3： 
//
// 
//输入：date = "2003-03-01"
//输出：60
// 
//
// 示例 4： 
//
// 
//输入：date = "2004-03-01"
//输出：61 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日 
// 
// Related Topics 数学 字符串 👍 86 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 1154 一年中的第几天
 * 2021-12-21 20:32:58
 * 思路：直接计算
 */
public class DayOfTheYear {
    public static void main(String[] args) {
        Solution solution = new DayOfTheYear().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int dayOfYear(String date) {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));

            int ans = 0;

            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                days[1] = 29;
            }

            for (int i = 0; i < month - 1; i++) {
                ans += days[i];
            }
            ans += day;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}