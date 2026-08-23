class Solution {
    public int fun(int r,int c,int n,int m,int grid[][]){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]!=1){
            return 0;
        }
        grid[r][c]=0;
        return 1+fun(r+1,c,n,m,grid)+fun(r-1,c,n,m,grid)+fun(r,c+1,n,m,grid)+fun(r,c-1,n,m,grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        int max=0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(grid[i][j]==1){
                    max=Math.max(max,fun(i,j,n,m,grid));
                }
            }
        }
        return max;
    }
}