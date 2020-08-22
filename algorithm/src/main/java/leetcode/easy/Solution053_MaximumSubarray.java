package leetcode.easy;

import common.PrintableMain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 21/08/2020
 * Time : 1:56 AM
 */
public class Solution053_MaximumSubarray extends PrintableMain {
    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        printResult(input, maxSubArray(input));
    }

    public static int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (max[i - 1] + nums[i] < nums[i]) max[i] = nums[i];
            else max[i] = max[i - 1] + nums[i];
        }
        int result = max[0];
        for (int i = 1; i < nums.length; ++i) {
            if (result < max[i]) result = max[i];
        }
        return result;
    }
}
