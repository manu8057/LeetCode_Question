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
    public ListNode fun(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode n=curr.next;
            curr.next=pre;
            pre=curr;
            curr=n;
        }
        return pre;
    }
    public int pairSum(ListNode head) {
        ListNode tem=head;
        ArrayList<Integer>l=new ArrayList<>();
        while(tem!=null){
            l.add(tem.val);
            tem=tem.next;
        }
        ListNode rev=fun(head);
        int max=0;
        int i=0;
        while(rev!=null){
            max=Math.max(rev.val+l.get(i++),max);
            rev=rev.next;
        }
        return max;
    }
}