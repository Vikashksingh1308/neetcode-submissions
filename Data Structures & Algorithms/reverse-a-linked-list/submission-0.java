/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

    while(current != null){
        ListNode next = current.next; //1. get the next address first
        current.next = previous; //2. change the pointer from "next" to "previous"
        previous = current; //3. bring previous forward
        current = next; //4. go to next item
    }

    return previous;
    }
}
