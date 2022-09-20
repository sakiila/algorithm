//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 444 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 106 从中序与后序遍历序列构造二叉树
 * 2021-02-08 11:11:17
 * 思路：注意边界
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);

        }

        private TreeNode build(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd) {
            if (inStart > inEnd) {
                return null;
            }

            int rootVal = postorder[postEnd];

            int index = inStart;
            for (; index <= inEnd; index++) {
                if (rootVal == inorder[index]) {
                    break;
                }
            }

            int leftSize = index - inStart;
            TreeNode node = new TreeNode(rootVal);
            node.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
            node.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}