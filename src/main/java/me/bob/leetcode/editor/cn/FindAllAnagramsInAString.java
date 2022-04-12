//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 662 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438 找到字符串中所有字母异位词
 * 2021-11-28 08:23:35
 * 思路：滑动窗口
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();

            int sl = s.length(), pl = p.length();
            if (sl < pl) {
                return res;
            }

            int[] sc = new int[26], pc = new int[26];
            for (int i = 0; i < pl; i++) {
                sc[s.charAt(i) - 'a']++;
                pc[p.charAt(i) - 'a']++;
            }

            for (int i = 0; i < sl - pl + 1; i++) {
                if (Arrays.equals(sc, pc)) {
                    res.add(i);
                }
                if (i + pl >= sl) {
                    break;
                }
                sc[s.charAt(i + pl) - 'a']++;
                sc[s.charAt(i) - 'a']--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}