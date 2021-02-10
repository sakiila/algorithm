//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 241 👎 0


package me.bob.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 567 字符串的排列
 * 2021-02-10 08:02:25
 * 思路：滑动窗口
 */
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }

            char[] ca = new char[26];
            char[] cb = new char[26];
            for (int i = 0; i < n; i++) {
                ca[s1.charAt(i) - 'a']++;
                cb[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(ca, cb)) {
                return true;
            }

            for (int i = n; i < m; i++) {
                cb[s2.charAt(i - n) - 'a']--;
                cb[s2.charAt(i) - 'a']++;
                if (Arrays.equals(ca, cb)) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}