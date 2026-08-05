class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int n=score.length;
        int m=score[0].length;
        PriorityQueue<int[]>q=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<n;i+=1){
            q.add(new int[]{score[i][k],i});
        }
        int ans[][]=new int[n][m];
        int r=0;
        while(!q.isEmpty()){
            int ar[]=q.poll();
            for(int i=0;i<m;i+=1){
                ans[r][i]=score[ar[1]][i];
            }
            r+=1;
        }
        return ans;
    }
}