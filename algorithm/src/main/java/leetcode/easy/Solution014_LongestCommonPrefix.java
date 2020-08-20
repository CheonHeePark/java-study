package leetcode.easy;

import common.PrintableMain;

import java.util.Arrays;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/08/2020
 * Time : 12:38 AM
 */
public class Solution014_LongestCommonPrefix extends PrintableMain {
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        printResult(input, longestCommonPrefix((input)));
        input = new String[]{"dog", "racecar", "car"};
        printResult(input, longestCommonPrefix((input)));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        StringBuffer sb = new StringBuffer();
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
           if (strs[i].length() < length)  length = strs[i].length();
        }
        int pos = -1;
        loop: while (++pos < length) {
            char c = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; ++i) {
                if (strs[i].charAt(pos) != c) break loop;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
