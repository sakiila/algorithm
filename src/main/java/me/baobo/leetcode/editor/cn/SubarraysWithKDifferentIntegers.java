//给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。 
//
// （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。） 
//
// 返回 A 中好子数组的数目。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,2,1,2,3], K = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 输入：A = [1,2,1,3,4], K = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 159 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 992 K 个不同整数的子数组
 * 2021-02-09 08:05:48
 * 思路：滑动窗口
 */
public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMost(A, K) - atMost(A, K - 1);
        }

        private int atMost(int[] A, int K) {
            int n = A.length;
            if (n == 0) {
                return 0;
            }

            int[] freq = new int[n + 1];
            int count = 0, res = 0, right = 0, left = 0;
            while (right < n) {
                if (freq[A[right]] == 0) {
                    count++;
                }
                freq[A[right]]++;
                right++;

                while (count > K) {
                    freq[A[left]]--;
                    if (freq[A[left]] == 0) {
                        count--;
                    }
                    left++;
                }
                res += right - left;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}