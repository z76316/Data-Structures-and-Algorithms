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
     * @return: nothing
     */
    private ListNode findMid (ListNode head) {
        ListNode fast, slow;
        slow = head;
        fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse (ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private void merge (ListNode head1, ListNode head2) {
        int count = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (count % 2 == 0) {
            dummy.next = head1;
            head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            count++;
        }
        if (head1 != null) dummy.next = head1;
        else dummy.next = head2;
    }
    
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return;
        
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }
}