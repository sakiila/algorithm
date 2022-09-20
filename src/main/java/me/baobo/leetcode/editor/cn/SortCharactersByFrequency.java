//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表 
// 👍 214 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 451 根据字符出现频率排序
 * 2021-02-14 10:48:25
 * 思路：桶排序
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            List<Character>[] buckets = new List[s.length() + 1];
            for (char c : map.keySet()) {
                int value = map.get(c);
                // 如果某个桶还未放入过字符（即未初始化），则初始化其为一个数组
                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(c);
            }

            StringBuffer res = new StringBuffer();
            for (int i = buckets.length - 1; i > 0; i--) {
                if (buckets[i] != null) {
                    for (int j = 0; j < buckets[i].size(); j++) {
                        for (int k = i; k > 0; k--) {
                            // 字符出现了几次就向 res 中添加几次该字符
                            res.append(buckets[i].get(j));
                        }
                    }
                }
            }

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}