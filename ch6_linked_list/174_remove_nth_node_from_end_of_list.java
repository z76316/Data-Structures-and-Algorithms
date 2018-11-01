/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy.next;
        ListNode tail = dummy;
        for (int i = 0; i < n; i++){
            if (head == null) return null;
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }
}