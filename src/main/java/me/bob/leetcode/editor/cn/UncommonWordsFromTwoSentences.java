//句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。 
//
// 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。 
//
// 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s1 = "this apple is sweet", s2 = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 
//输入：s1 = "apple apple", s2 = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 200 
// s1 和 s2 由小写英文字母和空格组成 
// s1 和 s2 都不含前导或尾随空格 
// s1 和 s2 中的所有单词间均由单个空格分隔 
// 
// Related Topics 哈希表 字符串 👍 118 👎 0


package me.bob.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 884 两句话中的不常见单词
 * 2022-01-30 10:32:51
 * 思路：哈希表
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map1 = new HashMap<>();
            Arrays.stream(s1.split(" ")).forEach(word -> map1.merge(word, 1, Integer::sum));
            Map<String, Integer> map2 = new HashMap<>();
            Arrays.stream(s2.split(" ")).forEach(word -> map2.merge(word, 1, Integer::sum));

            Set<String> set = new HashSet<>();
            set.addAll(map1.entrySet().stream().filter(entry -> entry.getValue() == 1 && !map2.containsKey(entry.getKey())).map(Map.Entry::getKey).collect(Collectors.toSet()));
            set.addAll(map2.entrySet().stream().filter(entry -> entry.getValue() == 1 && !map1.containsKey(entry.getKey())).map(Map.Entry::getKey).collect(Collectors.toSet()));

            return set.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}