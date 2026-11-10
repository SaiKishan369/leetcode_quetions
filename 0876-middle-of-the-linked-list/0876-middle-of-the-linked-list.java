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
    public ListNode middleNode(ListNode head) {
        ListNode current=head;
        int size=1;
        while(current.next != null){
            size++;
            current=current.next;
        }
        int middle=size/2+1;
        ListNode sol=head;
        int i=1;
        while(i<middle){
            i++;
            sol=sol.next;
        }
        return sol;
    }
}