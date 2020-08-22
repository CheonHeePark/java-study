package leetcode.easy;

import common.PrintableMain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 21/08/2020
 * Time : 1:46 AM
 */
public class Solution035_SearchInsertPosition extends PrintableMain {
    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};
        int target = 5;
        printResult(input, searchInsert(input, target));
        target = 2;
        printResult(input, searchInsert(input, target));
        target = 7;
        printResult(input, searchInsert(input, target));
        target = 0;
        printResult(input, searchInsert(input, target));
    }

    public static int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}
