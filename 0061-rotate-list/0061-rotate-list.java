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
    public ListNode rotateRight(ListNode head, int k) {
        int n=0;
        ListNode tem=head;
        if(head==null || head.next==null) return head;
        ArrayList<Integer>l=new ArrayList<>();
        while(tem!=null){
            n+=1;
            l.add(tem.val);
            tem=tem.next;
        }
        k=k%n;
        ListNode ans=new ListNode(0);
        ListNode jk=ans;
        for(int i=n-k;i<n;i++){
            ListNode node=new ListNode(l.get(i));
            jk.next=node;
            jk=jk.next;
        }
        for(int i=0;i<n-k;i++){
            ListNode node=new ListNode(l.get(i));
            jk.next=node;
            jk=jk.next;
        }
        return ans.next;
    }
}