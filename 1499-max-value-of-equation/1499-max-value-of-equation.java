class Solution {
    public int findMaxValueOfEquation(int[][] points,int k){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<points.length;i+=1){
            int x=points[i][0];
            int y=points[i][1];
            while(!pq.isEmpty() && x-pq.peek()[1]>k){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans=Math.max(ans,x+y+pq.peek()[0]);
            }
            pq.offer(new int[]{y-x,x});
        }
        return ans;
    }
}