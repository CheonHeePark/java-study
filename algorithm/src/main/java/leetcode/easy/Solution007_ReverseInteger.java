package leetcode.easy;

public class Solution007_ReverseInteger {
    public static void main(String[] args) {
        Solution007_ReverseInteger solution007_reverseInteger = new Solution007_ReverseInteger();
        System.out.println(solution007_reverseInteger.reverse(123));
        System.out.println(solution007_reverseInteger.reverse(-123));
        System.out.println(solution007_reverseInteger.reverse(120));
        System.out.println(solution007_reverseInteger.reverse(1534236469));
        System.out.println(solution007_reverseInteger.reverse(-2147483648));
    }

    /**
     * 입력으로 들어온 수를 뒤집어서 반환 (123 -> 321, -123 -> -321)
     * @param x 2^-31 ~ 2^31-1 사이의 값
     * @return
     */
    public int reverse(int x) {
        long src = Math.abs(x);
        if (src < Math.pow(2, -31) || src > Math.pow(2, 31) - 1) return 0;
        String r = String.valueOf(src);

        long answer = 0;
        for (int i = r.length() - 1; i >= 0; --i) {
            answer += (Integer.parseInt((String.valueOf(r.charAt(i)))) * (long)Math.pow(10, i));
        }

        if (answer < Math.pow(2, -31) || answer > Math.pow(2, 31) - 1) return 0;
        if (x < 0) return (0 - (int)answer);
        return (int)answer;
    }
}
