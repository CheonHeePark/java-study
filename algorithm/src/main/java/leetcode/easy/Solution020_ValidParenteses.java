package leetcode.easy;

import common.PrintableMain;

import java.util.Stack;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/08/2020
 * Time : 12:59 AM
 */
public class Solution020_ValidParenteses extends PrintableMain {
    public static void main(String[] args) {
        String input = "()";
        printResult(input, isValid(input));
        input = "()[]{}";
        printResult(input, isValid(input));
        input = "(]";
        printResult(input, isValid(input));
        input = "([)]";
        printResult(input, isValid(input));
        input = "{[]}";
        printResult(input, isValid(input));
    }

    private static boolean isValid(String s) {
        Stack<String> stack = new Stack();
        final char[] opens = {'(', '{', '['};
        int length = s.length();
        loop: for (int i = 0; i < length; ++i) {
            char current = s.charAt(i);
            for (char j : opens) {
                if (current == j) {
                    stack.push(String.valueOf(current));
                    continue loop;
                }
            }
            if (!stack.isEmpty()) {
                String top = stack.peek();
                if ((top.charAt(0) == '(' && current == ')') ||
                        (top.charAt(0) == '{' && current == '}') ||
                        (top.charAt(0) == '[' && current == ']')) {
                    stack.pop();
                    continue;
                }
            }
            return false;
        }
        return stack.isEmpty();
    }
}
