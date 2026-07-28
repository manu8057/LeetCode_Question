class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int el:nums) pq.add((long)el);
        int c=0;
        while(pq.size()>=2 && pq.peek()<(long)k){
            long a=pq.poll();
            long b=pq.poll();
            long r=Math.min(a,b)*2+Math.max(a,b);
            pq.add(r);
            c+=1;
        }
        return c;
    }
}