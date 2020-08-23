package leetcode.easy;

import common.PrintableMain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 22/08/2020
 * Time : 11:15 PM
 */
public class Solution067_AddBinary extends PrintableMain {
    /**
     * 이진수 값이 스트링 형태의 입력으로 들어온다.
     * 두 이진수를 더한 값을 스트링 형태로 출력한다.
     * 입력의 길이는 1~10,000
     *
     * @param args
     */
    public static void main(String[] args) {
        String input1 = "11";
        String input2 = "1";
        printResultWithManyInput(addBinary(input1, input2), input1, input2);
        input1 = "1010";
        input2 = "1011";
        printResultWithManyInput(addBinary(input1, input2), input1, input2);
        input1 = "0";
        input2 = "1";
        printResultWithManyInput(addBinary(input1, input2), input1, input2);
        input1 = "0";
        input2 = "0";
        printResultWithManyInput(addBinary(input1, input2), input1, input2);
        input1 = "11";
        input2 = "11";
        printResultWithManyInput(addBinary(input1, input2), input1, input2);
    }

    public static String addBinary(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int i = a1.length - 1;
        int j = b1.length - 1;
        int offset = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a1[i] - '0' : 0;
            int y = j >= 0 ? b1[j] - '0' : 0;
            int k = (x + y + offset) % 2;
            offset = (x + y + offset) / 2;
            sb.append(k);
            --i;
            --j;
        }
        if (offset != 0) sb.append(offset);
        return sb.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int offset = 0;
        int length = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();
        int aPos = a1.length;
        int bPos = b1.length;
        for (int i = 0; i < length; ++i) {
            aPos -= 1;
            int a2 =  (aPos >= 0) ? a1[aPos] - '0' : 0;
            bPos -= 1;
            int b2 =  (bPos >= 0) ? b1[bPos] - '0' : 0;
            int k = (a2 + b2 + offset) % 2;
            result.append(k);
            offset = (a2 + b2 + offset) / 2;
        }
        if (offset != 0) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
