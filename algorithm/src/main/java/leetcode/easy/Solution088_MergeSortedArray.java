package leetcode.easy;

import java.util.Arrays;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 26/08/2020
 * Time : 11:51 PM
 */
public class Solution088_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        System.out.println("input : " + Arrays.toString(nums1) + " " + m + " " + Arrays.toString(nums2) + " " + n);
        merge(nums1, m, nums2, n);
        System.out.println("result: " + Arrays.toString(nums1));

        nums1 = new int[] {4,0,0,0,0,0};
        m = 1;
        nums2 = new int[] {1,2,3,5,6};
        n = 5;
        System.out.println("input : " + Arrays.toString(nums1) + " " + m + " " + Arrays.toString(nums2) + " " + n);
        merge(nums1, m, nums2, n);
        System.out.println("result: " + Arrays.toString(nums1));
        nums1 = new int[] {4,0,0,0,0,0};
        merge2(nums1, m, nums2, n);
        System.out.println("result: " + Arrays.toString(nums1));
    }

    // 다른 분이 작성한 코드 분석. 이생각을 어떻게 한거지?
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length;
        m -= 1;
        n -= 1;
        //idx : 가장 큰 값이 들어갈 인덱스
        while (--idx >= 0) {
            if (m < 0) {
                // nums1에는 더이상 들어갈 아이템이 없는경우 (나머진 다 0)
                nums1[idx] = nums2[n];
                // nums2의 값을 하나 사용했으므로 다음 인덱스로 이동한다.
                --n;

            } else if (n < 0) {
                // nums2에는 더이상 들어갈 아이템이 없는경우 (나머진 다 nums1에 있다, nums2의 모든 값은 현재 nums1에 있는 값보다 크다.)
                nums1[idx] = nums1[m];
                // nums1의 값을 하나 사용했으므로 다음 인덱스로 이동한다.
                --m;

            } else if (nums1[m] < nums2[n])  {
                // nums2의 최대값이 nums1의 최대값보다 큰 경우, nums2의 값을 사용한다.
                nums1[idx] = nums2[n];
                // nums2의 값을 하나 사용했으므로 다음 인덱스로 이동한다.
                --n;

            } else if (nums1[m] >= nums2[n]) {
                // nums1의 최대값이 nums2의 최대값보다 같거나 같으면 nums1의 값을 사용한다.
                nums1[idx] = nums1[m];
                // nums1의 값을 하나 사용했으므로 다음 인덱스로 이동한다.
                --m;
            }
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; ++i) nums1[i + m] = nums2[i];
        int left = 0;
        int right = nums1.length - 1;
        int[] sortedNums = new int[m + n];
        mergeSort(nums1, left, right, sortedNums);
    }

    private static void mergeSort(int[] nums, int left, int right, int[] sortedNums) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid, sortedNums);
            mergeSort(nums, mid + 1, right, sortedNums);
            tryMerge(nums, left, right, sortedNums);
        }
    }

    private static void tryMerge(int[] nums, int left, int right, int[] sortedNums) {
        int mid = (left + right) >> 1;
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sortedNums[k++] = nums[i++];
            } else {
                sortedNums[k++] = nums[j++];
            }
        }
        if (i > mid) {
            for (int idx = j; idx <= right; ++idx) {
                sortedNums[k++] = nums[idx];
            }
        } else {
            for (int idx = i; idx <= mid; ++idx) {
                sortedNums[k++] = nums[idx];
            }
        }

        for (int idx = left; idx <= right; ++idx) {
            nums[idx] = sortedNums[idx];
        }
    }
}
