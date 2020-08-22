package leetcode.easy;

import common.PrintableMain;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 22/08/2020
 * Time : 10:22 PM
 */
public class Solution066_PlusOne extends PrintableMain {
    /**
     * 각 자리수에 1을 더한다.
     * 배열의 길이는 1~100
     * 배열의 각 자리수는 0~9의 숫자
     * @param args
     */
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        printResult(input, plusOne(input.clone()));
        input = new int[]{4, 3, 2, 1};
        printResult(input, plusOne(input.clone()));
        input = new int[]{0};
        printResult(input, plusOne(input.clone()));
        input = new int[]{9,9,9};
        printResult(input, plusOne(input.clone()));
        input = new int[]{9,0,9};
        printResult(input, plusOne(input.clone()));
        input = new int[]{9};
        printResult(input, plusOne(input.clone()));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i>=0; --i) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
