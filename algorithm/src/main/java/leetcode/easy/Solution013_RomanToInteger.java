package leetcode.easy;

import common.PrintableMain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 13/08/2020
 * Time : 1:50 AM
 */
public class Solution013_RomanToInteger extends PrintableMain {
    public static void main(String[] args) {
        Solution013_RomanToInteger app = new Solution013_RomanToInteger();
        String input = "III";
        printResult(input, romanToInt(input));
        input = "IV";
        printResult(input, romanToInt(input));
        input = "IX";
        printResult(input, romanToInt(input));
        input = "LVIII";
        printResult(input, romanToInt(input));
        input = "MCMXCIV"; // 1994
        printResult(input, romanToInt(input));
        input = "MDCCCLXXXIV"; // 1884
        printResult(input, romanToInt(input));
        input = "MMCCCXCIX"; // 2399
        printResult(input, romanToInt(input));
    }

    private static int getNumber(char c) {
        if      (c == 'I') {  return 1; }
        else if (c == 'V') {  return 5; }
        else if (c == 'X') {  return 10; }
        else if (c == 'L') {  return 50; }
        else if (c == 'C') {  return 100; }
        else if (c == 'D') {  return 500; }
        else if (c == 'M') {  return 1000; }
        return 0;
    }

    private static int romanToInt(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length - 1; ++i) {
            int current = getNumber(s.charAt(i));
            int next    = getNumber(s.charAt(i + 1));
            if (current >= next) result += current;
            else result -= current;
        }
        result += getNumber(s.charAt(length - 1));
        return result;
    }
}
