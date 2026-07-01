class Solution {
    public boolean check(int val,int dis[][],int n){
        if(dis[0][0]<val)return false;
        boolean vis[][]=new boolean[n][n];
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0]=true;
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        while(!q.isEmpty()){
            int ar[]=q.poll();
            int r=ar[0];
            int c=ar[1];
            if(r==n-1&&c==n-1)return true;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<n&&!vis[nr][nc]&&dis[nr][nc]>=val){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>>grid){
        int n=grid.size();
        int dis[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],-1);
        }
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dis[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        while(!q.isEmpty()){
            int ar[]=q.poll();
            int r=ar[0];
            int c=ar[1];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<n&&dis[nr][nc]==-1){
                    dis[nr][nc]=dis[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        int l=0;
        int h=Math.min(dis[0][0],dis[n-1][n-1]);
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(check(mid,dis,n)){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}