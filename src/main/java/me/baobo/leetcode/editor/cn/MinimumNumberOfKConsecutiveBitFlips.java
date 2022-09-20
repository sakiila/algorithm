//在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0
//。 
//
// 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [0,1,0], K = 1
//输出：2
//解释：先翻转 A[0]，然后翻转 A[2]。
// 
//
// 示例 2： 
//
// 
//输入：A = [1,1,0], K = 2
//输出：-1
//解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
// 
//
// 示例 3： 
//
// 
//输入：A = [0,0,0,1,0,1,1,0], K = 3
//输出：3
//解释：
//翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
//翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
//翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// 1 <= K <= A.length 
// 
// Related Topics 贪心算法 Sliding Window 
// 👍 76 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 995 K 连续位的最小翻转次数
 * 2021-02-18 08:50:19
 * 思路：滑动窗口+贪心
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfKConsecutiveBitFlips().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minKBitFlips(int[] A, int K) {
            int len = A.length;
            // 边界队列
            Deque<Integer> transformRange = new LinkedList<>();

            int cnt = 0;
            for (int i = 0; i < len; i++) {
                // 到达当前队列中最小的边界时，要将其排除
                if (!transformRange.isEmpty() && transformRange.peekFirst() == i) {
                    transformRange.pollFirst();
                }
                // 第i个元素的实际值，为A[i]加上翻转次数
                int cur = A[i] + transformRange.size();

                // 当前位置的实际值不为1的情况
                if (cur % 2 == 0) {
                    // 表示新的边界已经到达数组长度上线，该情况不可能成立，返回-1
                    if (i + K > len) {
                        return -1;
                    }
                    // 将[i, i + K]之间的元素翻转一次，将翻转的范围边界加入队列
                    transformRange.offerLast(i + K);
                    cnt++;
                }
            }

            return cnt;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}