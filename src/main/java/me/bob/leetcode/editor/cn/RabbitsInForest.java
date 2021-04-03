//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。 
//
// 返回森林中兔子的最少数量。 
//
// 
//示例:
//输入: answers = [1, 1, 2]
//输出: 5
//解释:
//两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//设回答了 "2" 的兔子为蓝色。
//此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//输入: answers = [10, 10, 10]
//输出: 11
//
//输入: answers = []
//输出: 0
// 
//
// 说明: 
//
// 
// answers 的长度最大为1000。 
// answers[i] 是在 [0, 999] 范围内的整数。 
// 
// Related Topics 哈希表 数学 
// 👍 53 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 781 森林中的兔子
 * 2021-04-04 06:31:11
 * 思路：数学题，如果有 x 只兔子都回答 y， 则有 x / (y + 1) * (y + 1) 只兔子
 */
public class RabbitsInForest {
    public static void main(String[] args) {
        Solution solution = new RabbitsInForest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            if (answers == null) {
                return 0;
            }

            int[] count = new int[1000];
            // 统计说了相同数量的兔子的数量
            for (int i = 0; i < answers.length; i++) {
                count[answers[i]]++;
            }

            int result = count[0];
            for (int j = 1; j < count.length; j++) {
                if (count[j] == 0) {
                    // 为0就跳过，因为这些颜色独一无二的兔子的数量已经包含在count[0]中了
                    continue;
                } else {
                    // 核心
                    result += ceil(count[j], j + 1) * (j + 1);
                }
            }

            return result;
        }

        // 得到 x / y 向上取整的结果的函数
        private int ceil(int x, int y) {
            if (x % y > 0) {
                return x / y + 1;
            } else {
                return x / y;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}