package leetcode.easy;

import java.util.Arrays;

public class Solution001_TwoSum {
    public static void main(String[] args) {
        int[] input = new int[]{9, 2, 7, 15};
        int target = 9;
        int[] result = twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 두 수의 덧셈
     * @param nums 입력 배열 (여기에서 두 수를 선택한다)
     * @param target 두 수의 합
     * @return nums에서 선택된 두 수의 Index
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        loop:
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }
        return answer;
    }
}
