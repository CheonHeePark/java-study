package common;

import java.util.Arrays;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/08/2020
 * Time : 1:15 AM
 */
public class PrintableMain {
    protected static <T, F> void printResult(T input, F function) {
        // 입력,출력 모두 String으로 반환해서 출력하고있으므로, 입력,출력을 toString();으로 추상화하였다.
        printResultWithManyInput(function, input);
    }

    protected static <T, F> void printResultWithManyInput(F function, T... input) {
        StringBuilder sb = new StringBuilder();
        sb.append("input : ");
        for (T t : input) {
            sb.append("<");
            sb.append(t).append("> ");
        }
        sb.append("\nresult: <").append(toString(function)).append(">\n");
        System.out.println(sb.toString());
    }

    private static <T> T toString(T input) {
        // TODO: 타입 추가가 될 경우 분기문이 추가될 수 있음 (추가없이 더 추상화할 방법은 없을까?)
        if (input instanceof Object[]) {
            return (T) Arrays.toString((Object[]) input);
        } else if (input instanceof int[]) {
            return (T) Arrays.toString((int[]) input);
        }
        return input;
    }
}
