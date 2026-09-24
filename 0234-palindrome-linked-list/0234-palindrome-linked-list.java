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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode newHead=reverse(mid);
        while(newHead != null){
            if(head.val != newHead.val){
                return false;
            }
            else{

            head=head.next;
            newHead=newHead.next;
            }
        }
        return true;

    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next== null){
            return head;
        }
        ListNode newNode=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }

}