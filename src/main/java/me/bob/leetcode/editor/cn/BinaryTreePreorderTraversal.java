//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 488 👎 0

package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144 二叉树的前序遍历
 * 2021-01-09 09:17:07
 * 思路：递归、栈
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper3(res, root);
            return res;
        }

        void helper(List<Integer> res, TreeNode node) {
            if (node == null) {
                return;
            }
            res.add(node.val);
            helper(res, node.left);
            helper(res, node.right);
        }

        void helper2(List<Integer> res, TreeNode node) {
            Deque<TreeNode> stack = new ArrayDeque<>();

            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    res.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
        }

        void helper3(List<Integer> res, TreeNode node) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();

            if (node != null) {
                stack.push(node);
            }

            while (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}