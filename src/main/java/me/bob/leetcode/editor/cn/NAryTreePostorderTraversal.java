//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 119 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 590 N叉树的后序遍历
 * 2021-01-09 09:55:51
 * 思路：递归、迭代栈
 */
public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            helper2(res, root);
            return res;
        }

        void helper(List<Integer> res, Node node) {
            if (node == null) {
                return;
            }
            for (Node child : node.children) {
                helper(res, child);
            }
            res.add(node.val);
        }

        void helper2(List<Integer> res, Node node) {
            Deque<Node> stack = new ArrayDeque<>();

            if (node != null) {
                stack.push(node);
            }

            while (!stack.isEmpty()) {
                node = stack.pop();
                res.add(0, node.val);
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}