package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class Solution001_TwoSum {
    public static void main(String[] args) {
        int[] input = new int[]{9, 2, 7, 15};
        int target = 9;
        int[] result = twoSum(input, target);
        System.out.println(Arrays.toString(result));
        input = new int[]{0, 4, 3, 0};
        target = 0;
        result = twoSum(input, target);
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int remine = target - nums[i];
            if (map.containsKey(remine)) {
                answer[0] = map.get(remine);
                answer[1] = i;
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}
