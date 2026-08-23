class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int fr=0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1) fr++;
            }
        }
        if(q.isEmpty() && fr>0) return -1;
        if(fr==0) return 0;
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        int min=0;
        while(!q.isEmpty()){
            int sz=q.size();
            boolean f=false;
            for(int i=0;i<sz;i+=1){
                int ar[]=q.poll();
                for(int k=0;k<4;k+=1){
                    int nr=dr[k]+ar[0];
                    int nc=dc[k]+ar[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        f=true;
                        fr-=1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            if(f) min+=1;
        }
        System.out.println(fr);
        if(fr>0) return -1;
        return min;
    }
}