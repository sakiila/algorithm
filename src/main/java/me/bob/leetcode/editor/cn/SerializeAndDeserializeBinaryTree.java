//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 465 👎 0


package me.bob.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297 二叉树的序列化与反序列化
 * 2021-02-08 10:17:02
 * 思路：可以用前序遍历
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serializeHelper(root, "");
        }

        private String serializeHelper(TreeNode node, String str) {
            if (node == null) {
                str += "None,";
            } else {
                str += node.val + ",";
                // 注意下面的等式
                str = serializeHelper(node.left, str);
                str = serializeHelper(node.right, str);
            }
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(split));
            return deserializeHelper(list);
        }

        public TreeNode deserializeHelper(List<String> list) {
            if (list.get(0).equals("None")) {
                list.remove(0);
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            node.left = deserializeHelper(list);
            node.right = deserializeHelper(list);

            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}