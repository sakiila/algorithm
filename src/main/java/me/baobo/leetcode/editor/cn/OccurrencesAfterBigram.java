//给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 
//second 紧随 first 出现，third 紧随 second 出现。 
//
// 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "alice is a good girl she is a good student", first = "a", second = 
//"good"
//输出：["girl","student"]
// 
//
// 示例 2： 
//
// 
//输入：text = "we will we will rock you", first = "we", second = "will"
//输出：["we","rock"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母和空格组成 
// text 中的所有单词之间都由 单个空格字符 分隔 
// 1 <= first.length, second.length <= 10 
// first 和 second 由小写英文字母组成 
// 
// Related Topics 字符串 👍 57 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078 Bigram 分词
 * 2021-12-26 16:18:20
 * 思路：遍历
 */
public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        Solution solution = new OccurrencesAfterBigram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            final String[] split = text.split(" ");
            if (split.length < 3) {
                return new String[0];
            }

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < split.length - 2; i++) {
                if (split[i].equals(first) && split[i + 1].equals(second)) {
                    ans.add(split[i + 2]);
                }
            }


            return ans.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}