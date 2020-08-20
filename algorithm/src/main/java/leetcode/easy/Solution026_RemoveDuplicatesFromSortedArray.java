package leetcode.easy;

import common.PrintableMain;

import java.util.Arrays;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/08/2020
 * Time : 1:52 AM
 */
public class Solution026_RemoveDuplicatesFromSortedArray extends PrintableMain {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,2};
        printResult(input, removeDuplicates(input));
        System.out.println(Arrays.toString(input));
        input = new int[]{0,0,1,1,1,2,2,3,3,4};
        printResult(input, removeDuplicates(input));
        System.out.println(Arrays.toString(input));
        input = new int[]{1,2};
        printResult(input, removeDuplicates(input));
        System.out.println(Arrays.toString(input));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int length = 1;
        int index = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[index] != nums[j]) {
                ++index;
                nums[index] = nums[j];
                ++length;
            }
        }
        return length;
    }
}
