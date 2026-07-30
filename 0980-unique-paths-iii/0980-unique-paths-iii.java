class Solution {
    int a=0;
    int b=0;
    public int fun(int r,int c,int n,int m,int grid[][],boolean vis[][],int st){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]==-1 || vis[r][c]){
            return 0;
        }
        if(r==a && c==b){
            return st==1?1:0;
        }
        vis[r][c]=true;
        int g=fun(r+1,c,n,m,grid,vis,st-1);
        int h=fun(r,c+1,n,m,grid,vis,st-1);
        int i=fun(r-1,c,n,m,grid,vis,st-1);
        int j=fun(r,c-1,n,m,grid,vis,st-1);
        vis[r][c]=false;
        return g+h+i+j;
    }
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int r=0;
        int c=0;
        int r1=0;
        int c1=0;
        int obs=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j+=1){
                if(grid[i][j]==1){
                    r=i;
                    c=j;
                }
                if(grid[i][j]==-1){
                    obs+=1;
                }
                if(grid[i][j]==2){
                    r1=i;
                    c1=j;
                }
            }
        }
        a=r1;
        b=c1;
        return fun(r,c,grid.length,grid[0].length,grid,vis,n*m-obs);
    }
}