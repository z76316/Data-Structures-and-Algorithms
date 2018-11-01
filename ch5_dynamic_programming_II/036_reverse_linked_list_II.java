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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevM = findKth(dummy, m-1);
        ListNode mth = prevM.next;
        ListNode nth = mth;
        ListNode post = mth.next;
        for (int i = m; i < n; i++) {
            if (post == null) {
                return null;
            }
            ListNode temp = post.next;
            post.next = nth;
            nth = post;
            post = temp;
        }
        
        prevM.next = nth;
        mth.next = post;
        return dummy.next;
    }
    private ListNode findKth (ListNode node, int k) {
        for (int i = 1; i <= k; i++) {
            if (node.next == null) return null;
            node = node.next;
        }
        return node;
    }
}