//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2079 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 20 有效的括号
 * 2021-01-07 09:32:24
 * 思路：栈（注意 if 判断时，为空）
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println("()[]{} " + solution.isValid("()[]{}"));
        System.out.println("([)] " + solution.isValid("([)]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            Deque<Character> stack = new ArrayDeque<>();
            for (Character c : s.toCharArray()) {
                if (!stack.isEmpty() && Objects.equals(map.get(stack.peek()), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}