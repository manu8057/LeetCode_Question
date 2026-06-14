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
    public static ListNode reverse(ListNode head){
        ListNode p=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode n=curr.next;
            curr.next=p;
            p=curr;
            curr=n;
        }
        return p;
    }
    public int pairSum(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode t=reverse(s.next);
        int max=0;
        while(t!=null){
            max=Math.max(max,t.val+head.val);
            head=head.next;
            t=t.next;
        }
        return max;
    }
}