package LeetCode.字符串;

import java.awt.geom.FlatteningPathIterator;
import java.util.Stack;

public class 有效的括号 {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if(stack.isEmpty() == true && (c == ')' || c == ']' || c == '}')) return false;
                if(c == '{') stack.push('{');
                if(c == '[') stack.push('[');
                if(c == '(') stack.push('(');
                if (c == '}') {
                    char m = stack.pop();
                    if(m != '{') return false;
                }
                if (c == ')') {
                    char m = stack.pop();
                    if(m != '(') return false;
                }
                if (c == ']') {
                    char m = stack.pop();
                    if(m != '[') return false;
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
