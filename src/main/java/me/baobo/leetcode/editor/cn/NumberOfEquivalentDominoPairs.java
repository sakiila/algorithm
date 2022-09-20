//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 50 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 1128 等价多米诺骨牌对的数量
 * 2021-01-26 08:20:31
 * 思路：哈希表，存数量
 */
public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < dominoes.length; i++) {
                int num = dominoes[i][0] < dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1]
                        : dominoes[i][1] * 10 + dominoes[i][0];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int res = 0;
            for (Integer num : map.keySet()) {
                int n = map.get(num);
                res += n * (n - 1) / 2;
            }

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}