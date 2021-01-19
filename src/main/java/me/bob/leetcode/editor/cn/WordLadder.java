//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 680 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 127 单词接龙
 * 2021-01-19 09:53:18
 * 思路：BFS
 */
public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            queue.offer(beginWord);
            visited.add(beginWord);

            int count = 0;
            while (queue.size() != 0) {
                int size = queue.size();
                count++;
                for (int i = 0; i < size; i++) {
                    String start = queue.poll();
                    for (String s : wordList) {
                        if (visited.contains(s)) {
                            continue;
                        }
                        // 不能转换的直接跳过
                        if (!canConvert(start, s)) {
                            continue;
                        }
                        // 返回结果
                        if (s.equals(endWord)) {
                            return count + 1;
                        }
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            return 0;
        }

        boolean canConvert(String a, String b) {
            int num = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    num++;
                    if (num > 1) {
                        return false;
                    }
                }
            }
            return num == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}