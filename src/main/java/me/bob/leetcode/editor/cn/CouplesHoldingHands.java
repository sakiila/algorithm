//N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交
//换座位。 
//
// 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)
//。 
//
// 这些情侣的初始座位 row[i] 是由最初始坐在第 i 个座位上的人决定的。 
//
// 示例 1: 
//
// 
//输入: row = [0, 2, 1, 3]
//输出: 1
//解释: 我们只需要交换row[1]和row[2]的位置即可。
// 
//
// 示例 2: 
//
// 
//输入: row = [3, 2, 0, 1]
//输出: 0
//解释: 无需交换座位，所有的情侣都已经可以手牵手了。
// 
//
// 说明: 
//
// 
// len(row) 是偶数且数值在 [4, 60]范围内。 
// 可以保证row 是序列 0...len(row)-1 的一个全排列。 
// 
// Related Topics 贪心算法 并查集 图 
// 👍 134 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 765 情侣牵手
 * 2021-02-14 08:59:58
 * 思路：并查集
 */
public class CouplesHoldingHands {
    public static void main(String[] args) {
        Solution solution = new CouplesHoldingHands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwapsCouples(int[] row) {
            int length = row.length, n = length / 2;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < length; i += 2) {
                unionFind.union(row[i] / 2, row[i + 1] / 2);
            }
            return n - unionFind.getCount();
        }

        private class UnionFind {
            private int count;
            private int[] parent;

            public UnionFind(int n) {
                this.count = n;
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int getCount() {
                return this.count;
            }

            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if (rootx == rooty) {
                    return;
                }
                parent[rootx] = rooty;
                count--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}