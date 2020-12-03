package collection.set;

import java.util.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2020/12/02
 * Time : 1:43 AM
 */

public class SetExample {
    private static long[] testTime = new long[2];
    public static void main(String[] args) {
        Set<Long> hashSet = new HashSet<>();
        Set<Long> treeSet = new TreeSet<>();
        Set<Long> linkedHashSet = new LinkedHashSet<>();

        System.out.println("Add. Size: 1,000,000");
        add(hashSet, 10000 * 100);
        add(treeSet, 10000 * 100);
        add(linkedHashSet, 10000 * 100);

        System.out.println("Add. Size: 10,000,000");
        add(hashSet, 10000 * 1000);
        add(treeSet, 10000 * 1000);
        add(linkedHashSet, 10000 * 1000);

        System.out.println("Search. Size: 11,000,000");
        search(hashSet);
        search(treeSet);
        search(linkedHashSet);
    }

    private static void add(Set set, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count / 2 - 1; ++i) {
            set.add(System.nanoTime());
        }
        testTime[0] = System.nanoTime();
        set.add(testTime[0]);
        for (int i = count / 2; i < count; ++i) {
            set.add(System.nanoTime());
        }
        long end = System.currentTimeMillis();
        testTime[1] = end;
        System.out.println("[Add] <" + set.getClass().getSimpleName() + "> wasted: " + (end - start));
    }

    private static void search(Set set) {
        int c = -1;
        while (++c < testTime.length) {
            long start = System.currentTimeMillis();
            set.contains(testTime[c]);
            long end = System.currentTimeMillis();
            System.out.println("[Get] <" + set.getClass().getSimpleName() + "> c:" + c + ", wasted: " + (end - start));
        }
    }
}

