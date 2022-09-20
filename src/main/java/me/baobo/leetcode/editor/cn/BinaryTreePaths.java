//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 709 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 257 二叉树的所有路径
 * 2022-04-16 10:23:27
 * 思路：递归 + 回溯
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            List<Integer> path = new ArrayList<>();
            helper(root, res, path);
            return res;
        }

        private void helper(TreeNode node, List<String> res, List<Integer> path) {
            path.add(node.val);
            if (node.left == null && node.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size() - 1; i++) {
                    sb.append(path.get(i)).append("->");
                }
                sb.append(path.get(path.size() - 1));
                res.add(sb.toString());
                return;
            }
            if (node.left != null) {
                helper(node.left, res, path);
                path.remove(path.size() - 1);
            }
            if (node.right != null) {
                helper(node.right, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}