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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    private ListNode findMid(ListNode head) {
        ListNode fast, slow;
        slow = head;
        fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        if (head1 != null) head.next = head1;
        else if (head2 != null) head.next = head2;
        
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;
        
        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        
        return merge(left, right);
    }
}