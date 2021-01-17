package me.bob.leetcode.editor.cn;

import java.util.Arrays;

public class AboutTest {
    public static void main(String[] args) {
        int[] tmp = new int[]{1, 3, 5, 2};
        int[] tmp2 = new int[tmp.length + 2];

        System.arraycopy(tmp, 0, tmp2, 1, tmp.length);
        System.out.println(Arrays.toString(tmp2));

        int[] ints = Arrays.copyOf(tmp, 5);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

    }

    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            parent[rootP] = rootQ;
            count--;
        }
    }
}
