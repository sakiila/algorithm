//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 503 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 208 实现 Trie (前缀树)
 * 2021-01-17 09:43:52
 * 思路：子节点数组
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private Trie[] children = new Trie[26];
        private boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie trie = this;
            for (char x : word.toCharArray()) {
                if (trie.children[x - 'a'] == null) {
                    trie.children[x - 'a'] = new Trie();
                }
                trie = trie.children[x - 'a'];
            }
            trie.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie trie = this;
            for (char x : word.toCharArray()) {
                if (trie.children[x - 'a'] == null) {
                    return false;
                }
                trie = trie.children[x - 'a'];
            }
            return trie.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (char x : prefix.toCharArray()) {
                if (trie.children[x - 'a'] == null) {
                    return false;
                }
                trie = trie.children[x - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}