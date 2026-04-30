class Solution {
    Long dp[][][];
    public long fun(int r,int c,int n,int m,int grid[][],int k){
        if(r>=n || c>=m || k<0){
            return -1000000007;
        }
        int tem=k;
        if(grid[r][c]!=0){
            k-=1;
        }
        if(k<0){
            return -1000000007;
        }
        if(r==n-1 && c==m-1){
            return grid[r][c];
        }
        if(dp[r][c][tem]!=null){
            return dp[r][c][tem];
        }
        long d=fun(r+1,c,n,m,grid,k);
        long ri=fun(r,c+1,n,m,grid,k);
        long max=Math.max(d,ri);
        if(max<=-1000000000){
            return dp[r][c][tem]=(long)-1000000007;
        }
        return dp[r][c][tem]=grid[r][c]+max;
    }

    public int maxPathScore(int[][] grid,int k){
        int n=grid.length;
        int m=grid[0].length;
        dp=new Long[n][m][k+1];
        long a=fun(0,0,n,m,grid,k);
        if(a<0){
            return -1;
        }
        return (int)a;
    }
}