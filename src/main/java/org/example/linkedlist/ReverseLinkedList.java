package org.example.linkedlist;

import java.util.List;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = new ListNode();
        reverse(head, tail);
        return tail;
    }

    public static ListNode reverse(ListNode head, ListNode tail) {
        if (head.next == null) {
            tail = head;
            return head;
        }
        ListNode current = reverse(head.next, tail);

        head.next = null;
        current.next = head;
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        reverseList(one);
    }
}
