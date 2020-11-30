package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2020/12/01
 * Time : 12:58 AM
 */

public class ListExample {
    public static void main(String[] args) {
        List<String> arrayList  = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        System.out.println("Add. Size:500000, StartIndex:0");
        add(arrayList, 100000 * 5);
        add(linkedList, 100000 * 5);

        System.out.println("Add. Size:100000, StartIndex:100");
        add(arrayList, 100000, 100);
        add(linkedList, 100000, 100);

        System.out.println("Add. Size:100000, StartIndex:1000");
        add(arrayList, 100000, 1000);
        add(linkedList, 100000, 1000);

        System.out.println("Add. Size:100000, StartIndex:10000");
        add(arrayList, 100000, 10000);
        add(linkedList, 100000, 10000);

        System.out.println("Add. Size:100000, StartIndex:100000");
        add(arrayList, 100000, 100000);
        add(linkedList, 100000, 100000);

        System.out.println("Get. Size:1000, StartIndex:0");
        get(arrayList, 10000, 0);
        get(linkedList, 10000, 0);

        System.out.println("Get. Size:1000, StartIndex:10000");
        get(arrayList, 10000, 10000);
        get(linkedList, 10000, 10000);

        System.out.println("Remove. Size:100000, StartIndex:0");
        remove(arrayList, 100000, 0);
        remove(linkedList, 100000, 0);

        System.out.println("Remove. Size:100000, StartIndex:100");
        remove(arrayList, 100000, 100);
        remove(linkedList, 100000, 100);

        System.out.println("Remove. Size:100000, StartIndex:Size - 100000");
        remove(arrayList, 100000, arrayList.size() - 100000);
        remove(linkedList, 100000, linkedList.size() - 100000);
    }

    private static void add(List<String> list, int loopCount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopCount; ++i) {
            String a = String.valueOf(System.currentTimeMillis());
            list.add(a);
        }
        System.out.println("Wasted add time<" + (list.getClass().getSimpleName()) + ">: " + (System.currentTimeMillis() - startTime));
    }

    private static void add(List<String> list, int addCount, int addIndex) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < addCount; ++i) {
            String a = String.valueOf(System.currentTimeMillis());
            list.add(addIndex, a);
        }
        System.out.println("Wasted add2 time<" + (list.getClass().getSimpleName()) + ">: " + (System.currentTimeMillis() - startTime));
    }

    private static void get(List<String> list, int loopCount, int startIndex) {
        long startTime = System.currentTimeMillis();
        for (int i = startIndex; i < loopCount; ++i) {
            String item = list.get(i);
        }
        System.out.println("Wasted get time<" + (list.getClass().getSimpleName()) + ">: " + (System.currentTimeMillis() - startTime));
    }

    private static void remove(List<String> list, int removeCount, int removeIndex) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < removeCount; ++i) {
           list.remove(removeIndex);
        }
        System.out.println("Wasted remove time<" + (list.getClass().getSimpleName()) + ">: " + (System.currentTimeMillis() - startTime));
    }
}
