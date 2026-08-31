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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return new int[]{-1,-1};
        }
        int a=head.val;
        int b=head.next.val;
        ListNode tem=head.next.next;
        int mind=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int pre=-1;
        int c=2;
        while(tem!=null){
            if((b>a && b>tem.val) || (b<a && b<tem.val)){
               if(pre!=-1){
                   mind=Math.min(c-pre,mind);
               }
               min=Math.min(min,c);
               max=Math.max(max,c);
               pre=c;
            }
            a=b;
            b=tem.val;
            c++;
            tem=tem.next;
        }
        if(min==max || min==Integer.MAX_VALUE || max==Integer.MIN_VALUE) return new int[]{-1,-1};
        return new int[]{mind,max-min};
    }
}