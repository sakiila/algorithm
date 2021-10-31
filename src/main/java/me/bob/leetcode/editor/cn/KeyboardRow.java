//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 153 👎 0


package me.bob.leetcode.editor.cn;

import java.util.*;

/**
 * 500 键盘行
 * 2021-10-31 09:48:53
 * 思路：Set 集合
 */
public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
            Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
            Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

            List<String> res = new ArrayList<>();
            for (String word : words) {
                char[] chars = word.toLowerCase().toCharArray();
                boolean flag1 = true;
                boolean flag2 = true;
                boolean flag3 = true;
                for (char c : chars) {
                    if (!set1.contains(c)) {
                        flag1 = false;
                    }
                    if (!set2.contains(c)) {
                        flag2 = false;
                    }
                    if (!set3.contains(c)) {
                        flag3 = false;
                    }
                }
                if (flag1 || flag2 || flag3) {
                    res.add(word);
                }
            }

            String[] ans = new String[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}