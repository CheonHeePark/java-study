package leetcode.easy;

import common.PrintableMain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 13/08/2020
 * Time : 12:56 AM
 */
public class Solution009_PalindromeNumber extends PrintableMain {
    public static void main(String[] args) {
        int input = 0;
        printResult(input, isPalindrome(input));
        input = 121;
        printResult(input, isPalindrome(input));
        input = -121;
        printResult(input, isPalindrome(input));
        input = 8448;
        printResult(input, isPalindrome(input));
        input = 283382;
        printResult(input, isPalindrome(input));
        input = 135727531;
        printResult(input, isPalindrome(input));
        input = Integer.MAX_VALUE;
        printResult(input, isPalindrome(input));
    }

    static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int length = (int) Math.ceil(Math.log10(x));
        int count  = length - 1;
        for (int i = 0; i < length/2; ++i) {
            int k = (int)Math.pow(10, count);
            int a = (x / k);
            int b = (x % 10);
            if (a != b) return false;
            x -= (a * k);
            x -= b;
            x /= 10;
            count -= 2;
        }
        return x < 10;
    }
}
