//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"] 
//
// 输入: word1 = “coding”, word2 = “practice”
//输出: 3
// 
//
// 输入: word1 = "makes", word2 = "coding"
//输出: 1
// 
//
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 数组 
// 👍 60 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 243 最短单词距离
 * 2021-05-03 15:46:52
 * 思路：一次遍历，记录下标
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        Solution solution = new ShortestWordDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            int a = -1, b = -1;
            int res = wordsDict.length;

            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    a = i;
                } else if (wordsDict[i].equals(word2)) {
                    b = i;
                }
                if (a != -1 && b != -1) {
                    res = Math.min(res, Math.abs(a - b));
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}