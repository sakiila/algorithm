//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 865 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 105 从前序与中序遍历序列构造二叉树
 * 2021-02-08 10:56:53
 * 思路：注意边界
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }

            int rootVal = preorder[preStart];
            int index = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (rootVal == inorder[i]) {
                    index = i;
                    break;
                }
            }

            TreeNode node = new TreeNode(rootVal);
            int leftSize = index - inStart;
            node.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
            node.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}