package leetcode.easy;

import common.PrintableMain;

import java.util.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 26/08/2020
 * Time : 11:01 PM
 */
public class Solution083_RemoveDuplicatesFromSortedList extends PrintableMain {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] input = new int[]{1, 1, 2};
        ListNode result = deleteDuplicates(makeInput(input));
        System.out.println("input : " + Arrays.toString(input));
        print(result);

        input = new int[]{-3, -1, 0, 0, 0, 3, 3};
        result = deleteDuplicates(makeInput(input));
        System.out.println("input : " + Arrays.toString(input));
        print(result);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        int lastVal = head.val;
        ListNode result = new ListNode(head.val);
        ListNode current = result;
        head = head.next;
        while (head != null) {
            if (lastVal != head.val) {
                current.next = new ListNode(head.val);
                current = current.next;
                lastVal = head.val;
            }
            head = head.next;
        }
        return result;
    }

    private static ListNode makeInput(int[] input) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int anInput : input) q.offer(anInput);

        ListNode inputNode = new ListNode(q.poll());
        ListNode temp = inputNode;
        while (!q.isEmpty()) {
            temp.next = new ListNode(q.poll());
            temp = temp.next;
        }
        return inputNode;
    }

    private static void print(ListNode result) {
        System.out.print("result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
