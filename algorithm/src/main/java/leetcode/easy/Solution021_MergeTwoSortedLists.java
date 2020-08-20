package leetcode.easy;

import common.PrintableMain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/08/2020
 * Time : 1:14 AM
 */
public class Solution021_MergeTwoSortedLists extends PrintableMain {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(1, l5);

        ListNode result = mergeTwoLists(l1, l4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        result = mergeTwoLists(null, null);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (l1 != null) {
            pq.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            pq.add(l2.val);
            l2 = l2.next;
        }

        if (pq.isEmpty()) return null;
        ListNode result = new ListNode(pq.poll());
        /*
        while (!pq.isEmpty()) {
           ListNode newNode = new ListNode(pq.poll());
           ListNode current = result;
           while (current.next != null) {
              current = current.next;
           }
           current.next = newNode;
        }
        */
        ListNode current = result;
        while (!pq.isEmpty()) {
            current.next = new ListNode(pq.poll()) ;
            current= current.next;
        }
        return result;
    }
}
