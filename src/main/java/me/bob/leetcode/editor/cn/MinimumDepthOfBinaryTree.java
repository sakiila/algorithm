//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 426 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 111 二叉树的最小深度
 * 2021-01-10 21:39:13
 * 思路：递归（注意下推条件）
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            // 当前节点 root 为空时，说明此处树的高度为 0，0 也是最小值
            if (root == null) {
                return 0;
            }

            // 当前节点 root 的左子树和右子树都为空时，说明此处树的高度为 1，1 也是最小值
            if (root.left == null && root.right == null) {
                return 1;
            }

            // 如果为其他情况，则说明当前节点有值，且需要分别计算其左右子树的最小深度，返回最小深度 +1
            int ans = Integer.MAX_VALUE;
            if (root.left != null) {
                ans = Math.min(ans, minDepth(root.left));
            }
            if (root.right != null) {
                ans = Math.min(ans, minDepth(root.right));
            }

            return ans + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}