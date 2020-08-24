package leetcode.easy;

import common.PrintableMain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 24/08/2020
 * Time : 1:11 AM
 */
public class Solution070_ClimbingStairs extends PrintableMain {
    /**
     * 계단 오르기
     * 한번에 1칸 혹은 2칸씩 오를 수 있으며, N개의 주어질 때 계단을 오를 수 있는 방법 경우의 수 구하기
     * N은 1 ~ 45
     *
     * @param args
     */
    public static void main(String[] args) {
        int input = 1;
        for (int i = input; i <= 10; ++i) {
            printResultWithManyInput(climbStairs(i), i);
            //printResult(i, climbStairs2(i));
        }
    }

    // way1. bottom-up
    public static int climbStairs(int n) {
        if (n == 1 || n == 2)  return n;
        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; ++i) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }

    // way2. top-down
    public static int climbStairs2(int n) {
        if (n == 1 || n == 2)  return n;
        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;
        return dfs(n, d);
    }
    private static int dfs(int i, int[] d) {
        if (i <= 2 || d[i] != 0) return d[i];
        return d[i] = dfs(i - 1, d) + dfs(i - 2, d);
        //return d[i];
    }
}
