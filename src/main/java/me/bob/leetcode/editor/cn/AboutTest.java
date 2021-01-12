package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AboutTest {
    public static void main(String[] args) {
        int[] tmp = new int[]{1, 3, 5, 2};
        int[] tmp2 = new int[tmp.length + 2];

        System.arraycopy(tmp, 0, tmp2, 1, tmp.length);
        System.out.println(Arrays.toString(tmp2));

        int[] ints = Arrays.copyOf(tmp, 5);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                results.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(results);
        }

        return res;
    }
}
