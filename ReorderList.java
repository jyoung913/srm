/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class ReorderList {
    class ListNode {
        ListNode next;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPre = head;
        // find middle point
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPre = slow;
            slow = slow.next;
        }
        slowPre.next = null;

        // reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = slow.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // merge two linked list starting head and end
        ListNode first = head;
        ListNode second = prev;
        boolean from_first = true;
        while (first != null || second != null) {
            if (from_first) {
                if (first.next == null) {
                    first.next = second;
                    return;
                }
                ListNode first_next = first.next;
                first.next = second;
                first = first_next;
            } else {
                if (second.next == null) {
                    second.next = first;
                    return;
                }
                ListNode second_next = second.next;
                second.next = first;
                second = second_next;
            }
            from_first = !from_first;

        }
    }
}