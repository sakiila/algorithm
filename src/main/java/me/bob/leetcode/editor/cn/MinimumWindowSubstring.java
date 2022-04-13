//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1786 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 76 最小覆盖子串
 * 2022-04-12 10:08:04
 * 思路：滑动窗口
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> sm = new HashMap<>();
            Map<Character, Integer> tm = new HashMap<>();
            for (char c : t.toCharArray()) {
                tm.put(c, tm.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int start = 0, length = Integer.MAX_VALUE;
            int count = 0;
            
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (tm.containsKey(c)) {
                    sm.put(c, sm.getOrDefault(c, 0) + 1);
                    if (sm.get(c).equals(tm.get(c))) {
                        count++;
                    }
                }
                while (tm.size() == count) {
                    if (right - left < length) {
                        length = right - left;
                        start = left;
                    }
                    char cl = s.charAt(left);
                    left++;
                    if (tm.containsKey(cl)) {
                        if (sm.get(cl).equals(tm.get(cl))) {
                            count--;
                        }
                        sm.put(cl, sm.get(cl) - 1);
                    }
                }
            }

            return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}