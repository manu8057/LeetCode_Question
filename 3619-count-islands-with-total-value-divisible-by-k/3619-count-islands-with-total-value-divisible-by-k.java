class Solution {
    public long fun(int r,int c,int n,int m,int grid[][]){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]==0){
            return 0;
        }
        long a=grid[r][c];
        grid[r][c]=0;
        return a+fun(r+1,c,n,m,grid)+fun(r,c+1,n,m,grid)+fun(r-1,c,n,m,grid)+fun(r,c-1,n,m,grid);
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    long a=fun(i,j,n,m,grid);
                    if(a%k==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}