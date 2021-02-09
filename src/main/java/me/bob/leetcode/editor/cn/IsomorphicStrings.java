//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 
// 👍 327 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 205 同构字符串
 * 2021-02-09 11:04:45
 * 思路：两个哈希表双射
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> ms = new HashMap<>();
            Map<Character, Character> mt = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i), b = t.charAt(i);
                if (ms.containsKey(a) && ms.get(a) != b) {
                    return false;
                }
                if (mt.containsKey(b) && mt.get(b) != a) {
                    return false;
                }
                ms.put(a, b);
                mt.put(b, a);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}